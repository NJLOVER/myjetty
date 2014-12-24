package http;

import org.eclipse.jetty.io.Buffers;
import org.eclipse.jetty.io.BuffersFactory;
import server.util.component.AbstractLifeCycle;

/**
 * Created by wanghm on 2014/12/24.
 */
public class HttpBuffersImpl extends AbstractLifeCycle implements HttpBuffers {
    private int _requestBufferSize=16*1024;
    private int _requestHeaderSize=6*1024;
    private int _responseBufferSize=32*1024;
    private int _responseHeaderSize=6*1024;
    private int _maxBuffers=1024;

    private Buffers.Type _requestBufferType=Buffers.Type.BYTE_ARRAY;
    private Buffers.Type _requestHeaderType=Buffers.Type.BYTE_ARRAY;
    private Buffers.Type _responseBufferType=Buffers.Type.BYTE_ARRAY;
    private Buffers.Type _responseHeaderType=Buffers.Type.BYTE_ARRAY;

    private Buffers _requestBuffers;
    private Buffers _responseBuffers;

    public HttpBuffersImpl()
    {
        super();
    }

    public int getRequestBufferSize()
    {
        return _requestBufferSize;
    }

    public void setRequestBufferSize(int requestBufferSize)
    {
        _requestBufferSize = requestBufferSize;
    }

    public int getRequestHeaderSize()
    {
        return _requestHeaderSize;
    }

    public void setRequestHeaderSize(int requestHeaderSize)
    {
        _requestHeaderSize = requestHeaderSize;
    }

    public int getResponseBufferSize()
    {
        return _responseBufferSize;
    }

    public void setResponseBufferSize(int responseBufferSize)
    {
        _responseBufferSize = responseBufferSize;
    }

    public int getResponseHeaderSize()
    {
        return _responseHeaderSize;
    }

    public void setResponseHeaderSize(int responseHeaderSize)
    {
        _responseHeaderSize = responseHeaderSize;
    }

    public Buffers.Type getRequestBufferType()
    {
        return _requestBufferType;
    }

    public void setRequestBufferType(Buffers.Type requestBufferType)
    {
        _requestBufferType = requestBufferType;
    }

    public Buffers.Type getRequestHeaderType()
    {
        return _requestHeaderType;
    }

    public void setRequestHeaderType(Buffers.Type requestHeaderType)
    {
        _requestHeaderType = requestHeaderType;
    }

    public Buffers.Type getResponseBufferType()
    {
        return _responseBufferType;
    }

    public void setResponseBufferType(Buffers.Type responseBufferType)
    {
        _responseBufferType = responseBufferType;
    }

    public Buffers.Type getResponseHeaderType()
    {
        return _responseHeaderType;
    }

    public void setResponseHeaderType(Buffers.Type responseHeaderType)
    {
        _responseHeaderType = responseHeaderType;
    }

    public void setRequestBuffers(Buffers requestBuffers)
    {
        _requestBuffers = requestBuffers;
    }

    public void setResponseBuffers(Buffers responseBuffers)
    {
        _responseBuffers = responseBuffers;
    }

    protected void doStart() throws Exception{
        _requestBuffers= BuffersFactory.newBuffers(_requestHeaderType, _requestHeaderSize, _requestBufferType, _requestBufferSize, _requestBufferType, getMaxBuffers());
        _responseBuffers=BuffersFactory.newBuffers(_responseHeaderType,_responseHeaderSize,_responseBufferType,_responseBufferSize,_responseBufferType,getMaxBuffers());
        super.doStart();
    }
    @Override
    protected void doStop()
            throws Exception
    {
        _requestBuffers=null;
        _responseBuffers=null;
    }

    public Buffers getRequestBuffers()
    {
        return _requestBuffers;
    }


    public Buffers getResponseBuffers()
    {
        return _responseBuffers;
    }

    public void setMaxBuffers(int maxBuffers)
    {
        _maxBuffers = maxBuffers;
    }

    public String toString()
    {
        return _requestBuffers+"/"+_responseBuffers;
    }

    public int getMaxBuffers()
    {
        return _maxBuffers;
    }

}
