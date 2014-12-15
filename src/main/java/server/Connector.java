package server;

import org.eclipse.jetty.io.Buffers;
import org.eclipse.jetty.io.EndPoint;

import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by wanghm on 2014/12/11.
 *
 */
public interface Connector extends LifeCycle{
    String getName();

    void open();

    void close();

    void setServer(Server server);

    Server getServer();

    int getRequestHeaderSize();

    void setRequestHeaderSize(int size);

    int getResponseHeaderSize();

    void setResponseHeaderSize(int size);

    Buffers getRequestBuffers();

    Buffers getResponseBuffers();

    int getRequestBufferSize();

    void setRequestBufferSize(int requestBufferSize);

    int getResponseBufferSize();

    void setResponseBufferSize(int responseBufferSize);

    //todo mark this ,i don't understand, integral 完整的
    int getIntegralPort();
    String getIntegralScheme();
    boolean isIntegral(Request request);
    int getConfidentialPort();
    String getConfidentialScheme();
    //https请求
    boolean isConfidential(Request request);
    //customize定制
    void customize(EndPoint endpoint, Request request) throws IOException;
    //Persist保持长连接?
    void persist(EndPoint endpoint) throws IOException;

    String getHost();
    void setHost(String hostname);
    void setPort(int port);
    int getPort();
    int getLocalPort();

    //Socket的最大空闲时间，以及在资源比较少(如线程池中的任务数比最大可用线程数要多)的情况下的最大空闲时间，当空闲时间超过这个时间后关闭当前连接(Socket)。
    int getMaxIdleTime();
    void setMaxIdleTime(int ms);
    int getLowResourceMaxIdleTime();
    void setLowResourceMaxIdleTime(int ms);
    // 是否当前Connector处于LowResources状态，即线程池中的任务数比最大可用线程数要多
    public boolean isLowResources();

    Object getConnection();
    //通过代理服务器获取负载均衡,可以讲真实的用户ip增加到header里面,XFF(X-Forwarded-For)
    boolean getResolveNames();
    //当前Connector处理的请求数
    public int getRequests();

    public long getConnectionsDurationTotal();

    public int getConnections();

    public int getConnectionOpen();

    public int getConnectionOpenMax();
    //duration持续
    // 当前Connector的最长连接持续时间
    public long getConnectionsDurationMax();
    // 当前Connector平均连接持续时间
    public double getConnectionsDurationMean() ;

    public double getConnectionsDurationStdDev();
    // 当前Connector的所有连接的平均请求数
    public double getConnectionsRequestsMean() ;

    // 当前Connector的所有连接的请求数标准偏差
    public double getConnectionsRequestsStdDev() ;
    // 当前Connector的所有连接的最大请求数
    public int getConnectionsRequestsMax();

    // 打开或关闭统计功能
    public void setStatsOn(boolean on);

    // 重置统计数据，以及统计开始时间
    public void statsReset();

    // 统计信息的开启时间戳
    public long getStatsOnMs();
}
