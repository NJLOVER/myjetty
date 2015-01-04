package server.nio;

import org.eclipse.jetty.io.Buffers.Type;
import server.AbstractConnector;

/**
 * Created by wanghm on 2014/12/15.
 */
public abstract class AbstractNIOConnector implements AbstractConnector {
    public AbstractNIOConnector()
    {
        _buffers.setRequestBufferType(Type.DIRECT);
        _buffers.setRequestHeaderType(Type.INDIRECT);
        _buffers.setResponseBufferType(Type.DIRECT);
        _buffers.setResponseHeaderType(Type.INDIRECT);
    }

    public boolean getUseDirectBuffers()
    {
        return getRequestBufferType()==Type.DIRECT;
    }

    public void setUseDirectBuffers(boolean direct)
    {
        _buffers.setRequestBufferType(direct?Type.DIRECT:Type.INDIRECT);
        _buffers.setResponseBufferType(direct?Type.DIRECT:Type.INDIRECT);
    }
}
