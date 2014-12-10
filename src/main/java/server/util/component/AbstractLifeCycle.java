package server.util.component;

import server.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wanghm on 2014/12/8.
 */
public class AbstractLifeCycle implements LifeCycle {

    private Logger logger = LoggerFactory.getLogger(AbstractLifeCycle.class);
    public static final String STOPPED="STOPPED";
    public static final String FAILED="FAILED";
    public static final String STARTING="STARTING";
    public static final String STARTED="STARTED";
    public static final String STOPPING="STOPPING";
    public static final String RUNNING="RUNNING";

    private final Object _lock = new Object();
    private final int __FAILED = -1, __STOPPED = 0, __STARTING = 1, __STARTED = 2, __STOPPING = 3;
    private volatile int _state = __STOPPED;

    protected final CopyOnWriteArrayList<Listener>_listeners = new CopyOnWriteArrayList<Listener>();

    @Override
    public void start() throws Exception {
        synchronized (_lock){
            try{
                if(_state == __STARTED || _state == __STARTING){
                    return;
                }
                setSarting();
                doStart();
                setStarted();
            }catch (Exception e){
                setFailed(e);
                throw e;
            }catch (Error e){
                setFailed(e);
                throw e;
            }
        }
    }

    protected void doStart() throws Exception {

    }

    protected  void doStop() throws Exception{

    }

    private void setStarted(){
        _state = __STARTED;
        logger.debug("Started {}",this);
        for(Listener listener : _listeners){
            listener.lifeCycleStarted(this);
        }
    }

    private void setSarting(){
        logger.debug("starting {}",this);
        _state = __STARTING;
        for(Listener listener : _listeners){
            listener.lifeCycleStarting(this);
        }
    }

    @Override
    public void stop() throws Exception {

    }

    public boolean isRunning()
    {
        final int state = _state;

        return state == __STARTED || state == __STARTING;
    }

    public boolean isStarted()
    {
        return _state == __STARTED;
    }

    public boolean isStarting()
    {
        return _state == __STARTING;
    }

    public boolean isStopping()
    {
        return _state == __STOPPING;
    }

    public boolean isStopped()
    {
        return _state == __STOPPED;
    }

    public boolean isFailed()
    {
        return _state == __FAILED;
    }

    @Override
    public void addLifeCycleListener(Listener listener) {
        _listeners.add(listener);
    }

    public void removeLifeCycleListener(org.eclipse.jetty.util.component.LifeCycle.Listener listener){
        _listeners.remove(listener);
    }
    public String getState()
    {
        switch(_state)
        {
            case __FAILED: return FAILED;
            case __STARTING: return STARTING;
            case __STARTED: return STARTED;
            case __STOPPING: return STOPPING;
            case __STOPPED: return STOPPED;
        }
        return null;
    }

    public static String getStatus(LifeCycle lc) {
        if (lc.isStarted()) return STARTED;
        if (lc.isStopping()) return STOPPING;
        if (lc.isStopped()) return STOPPED;
        if (lc.isStarting()) return STARTING;
        return FAILED;
    }

    private void setFailed(Throwable th){
        _state = __FAILED;
        logger.warn(FAILED+" " + this+": "+th,th);
        for(Listener listener : _listeners)
            listener.lifeCycleFailure(this,th);
    }
}
