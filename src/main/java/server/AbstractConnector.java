package server;

import http.HttpBuffers;
import http.HttpBuffersImpl;
import http.HttpHeaders;
import http.HttpSchemes;
import org.eclipse.jetty.io.EofException;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.util.component.AggregateLifeCycle;
import server.util.component.Dumpable;
import server.util.thread.ThreadPool;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wanghm on 2014/12/15.
 */
public abstract class AbstractConnector extends AggregateLifeCycle implements HttpBuffers, Connector, Dumpable {
    private static Logger logger = LoggerFactory.getLogger(AbstractConnector.class);

    private String _name;
    private Server _server;
    private ThreadPool _threadPool;
    private String _host;//ip
    private int _port = 0;//端口
    private String _integralScheme = HttpSchemes.HTTP;
    private int _integralPort = 0;
    private String _confidentialScheme = HttpSchemes.HTTPS;
    private int _confidentialPort = 0;
    private int _acceptQueueSize = 0;
    private int _acceptors = 1;//接受链接的线程数
    private int _acceptorPriorityOffset = 0;//线程的优先级
    private boolean _useDNS;
    private boolean _forwarded;
    private String _hostHeader;

    private String _forwardedHostHeader = HttpHeaders.X_FORWARDED_HOST;
    private String _forwardedServerHeader = HttpHeaders.X_FORWARDED_SERVER;
    private String _forwardedForHeader = HttpHeaders.X_FORWARDED_FOR;
    private String _forwardedProtoHeader = HttpHeaders.X_FORWARDED_PROTO;
    private String _forwardedCipherSuiteHeader;
    private String _forwardedSslSessionIdHeader;
    private boolean _reuseAddress = true;

    protected int _maxIdleTime = 200000;
    protected int _lowResourceMaxIdleTime = -1;
    protected int _soLingerTime = -1;//设置socket链接关闭后的行为,此处设置的是豪秒

    private transient Thread[] _acceptorThreads;

    private final AtomicLong _statsStartedAt = new AtomicLong(-1);

    private final CounterStatistic _connectionStats = new CounterStatistic();
    /** requests per connection */
    private final SampleStatistic _requestStats = new SampleStatistic();
    /** duration of a connection */
    private final SampleStatistic _connectionDurationStats = new SampleStatistic();

    protected final HttpBuffersImpl _buffers = new HttpBuffersImpl();

    public AbstractConnector()
    {
        addBean(_buffers);
    }

    public Server getServer()
    {
        return _server;
    }

    /* ------------------------------------------------------------ */
    public void setServer(Server server)
    {
        _server = server;
    }

    /* ------------------------------------------------------------ */
    public ThreadPool getThreadPool()
    {
        return _threadPool;
    }

    public void setThreadPool(ThreadPool pool)
    {
        removeBean(_threadPool);
        _threadPool = pool;
        addBean(_threadPool);
    }

    public void setHost(String host)
    {
        _host = host;
    }

    public String getHost()
    {
        return _host;
    }

    public void setPort(int port)
    {
        _port = port;
    }

    public int getPort()
    {
        return _port;
    }

    public int getMaxIdleTime()
    {
        return _maxIdleTime;
    }

    //设置最大空闲时间
    public void setMaxIdleTime(int maxIdleTime)
    {
        _maxIdleTime = maxIdleTime;
    }
    //低资源条件下的最大空闲时间
    public int getLowResourcesMaxIdleTime()
    {
        return _lowResourceMaxIdleTime;
    }

    public void setLowResourcesMaxIdleTime(int maxIdleTime)
    {
        _lowResourceMaxIdleTime = maxIdleTime;
    }

    /*@Deprecated
    public final int getLowResourceMaxIdleTime()
    {
        return getLowResourcesMaxIdleTime();
    }*/
    //so_linger属性的使用还在探索中
    public int getSoLingerTime()
    {
        return _soLingerTime;
    }

    public int getAcceptQueueSize()
    {
        return _acceptQueueSize;
    }

    public void setAcceptQueueSize(int acceptQueueSize)
    {
        _acceptQueueSize = acceptQueueSize;
    }

    public int getAcceptors()
    {
        return _acceptors;
    }

    public void setAcceptors(int acceptors){
        if(acceptors > 2* Runtime.getRuntime().availableProcessors()){
            logger.warn("Acceptors should be <=2*availableProcessors: " + this);
        }
        _acceptors = acceptors;
    }

    public void setSoLingerTime(int soLingerTime)
    {
        _soLingerTime = soLingerTime;
    }
    @Override
    protected void doStart() throws Exception{
        if(_server == null)
            throw new IllegalStateException("No server");
        //打开监听程序
        open();
        if(_threadPool == null){
            _threadPool = _server.getThreadPool();
            addBean(_threadPool,false);
        }
        super.doStart();

        // Start selector thread
        synchronized (this){
            _acceptorThreads = new Thread[getAcceptors()];

            for(int i = 0;i<_acceptorThreads.length;i++){
                if(!_threadPool.dispath(new Acceptor(i))){
                    throw new IllegalStateException("!accepting");
                }
                if (_threadPool.isLowOnThreads())
                    logger.warn("insufficient threads configured for {}",this);
            }
        }
        logger.info("Started {}",this);
    }

    @Override
    protected void doStop() throws Exception{
        try{
            close();
        }catch (Exception e){
            logger.warn("connector close warn:{}",e);
        }
        super.doStop();
        Thread[] acceptors;
        synchronized (this){
            acceptors = _acceptorThreads;
            _acceptorThreads = null;
        }
        if(acceptors != null){
            for(Thread thread : acceptors){
                if(thread != null)
                    thread.interrupt();
            }
        }
    }

    public void join() throws InterruptedException {
        Thread[] threads;
        synchronized (this){
            threads = _acceptorThreads;
        }
        if(threads != null)
            for(Thread thread : threads)
                if(thread != null)
                    thread.join();
    }

    protected void configure(Socket socket){
        try{
            socket.setTcpNoDelay(true);//设置无延迟链接
        }catch (Exception e){

        }
    }

    private class Acceptor implements Runnable{

        int _acceptor = 0;

        Acceptor(int id)
        {
            _acceptor = id;
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            String name;
            //AbstractConnector.this是对外部类的当前对象引用
            synchronized (AbstractConnector.this){
                if(_acceptorThreads == null)
                    return;
                _acceptorThreads[_acceptor] = current;
                name = _acceptorThreads[_acceptor].getName();
                current.setName(name + " Acceptor" + _acceptor + " " + AbstractConnector.this);
            }
            int old_priority = current.getPriority();
            try{
                current.setPriority(old_priority - _acceptorPriorityOffset);
                while(isRunning() && getConnection() != null){
                    try{
                        accept(_acceptor);
                    }catch (EofException e)
                    {
                    }
                    catch (IOException e)
                    {
                    }
                    catch (InterruptedException x)
                    {
                        // Connector has been stopped
                    }
                    catch (Throwable e)
                    {
                        logger.warn("Acceptor warn:{}",e);
                    }
                }
            }finally
            {
                current.setPriority(old_priority);
                current.setName(name);

                synchronized (AbstractConnector.this)
                {
                    if (_acceptorThreads != null)
                        _acceptorThreads[_acceptor] = null;
                }
            }
        }

        public String getName()
        {
            if (_name == null)
                _name = (getHost() == null?"0.0.0.0":getHost()) + ":" + (getLocalPort() <= 0?getPort():getLocalPort());
            return _name;
        }




    }

    public void setName(String name)
    {
        _name = name;
    }

    public int getRequests()
    {
        return (int)_requestStats.getTotal();
    }

    public long getConnectionsDurationTotal()
    {
        return _connectionDurationStats.getTotal();
    }

    public int getConnections()
    {
        return (int)_connectionStats.getTotal();
    }

    public int getConnectionsOpen()
    {
        return (int)_connectionStats.getCurrent();
    }


}
