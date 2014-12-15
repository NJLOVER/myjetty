package http;

import org.eclipse.jetty.io.Buffer;

/**
 * Created by wanghm on 2014/12/15.
 */
public interface Buffers {
    enum Type {BYTE_ARRAY,DIRECT,INDIRECT}

    Buffer getHeader();
    Buffer getBuffer();
    Buffer getBuffer(int size);

    void returnBuffer(Buffer buffer);
}
