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
    int getMaxIdleTime();
    void setMaxIdleTime(int ms);
    //todo maybe
    int getLowResourceMaxIdleTime();
    void setLowResourceMaxIdleTime(int ms);
}
