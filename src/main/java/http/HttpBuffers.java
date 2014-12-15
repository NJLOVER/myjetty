package http;

/**
 * Created by wanghm on 2014/12/15.
 */
public interface HttpBuffers {
    public int getRequestBufferSize();

    public void setRequestBufferSize(int requestBufferSize);

    public int getRequestHeaderSize();

    public void setRequestHeaderSize(int requestHeaderSize);

    public int getResponseBufferSize();

    public void setResponseBufferSize(int responseBufferSize);

    public int getResponseHeaderSize();

    public void setResponseHeaderSize(int responseHeaderSize);

    public Buffers.Type getRequestBufferType();

    public Buffers.Type getRequestHeaderType();

    public Buffers.Type getResponseBufferType();

    public Buffers.Type getResponseHeaderType();

    public void setRequestBuffers(Buffers requestBuffers);

    public void setResponseBuffers(Buffers responseBuffers);

    public Buffers getRequestBuffers();

    public Buffers getResponseBuffers();

    public void setMaxBuffers(int maxBuffers);

    public int getMaxBuffers();
}
