package http;

import org.eclipse.jetty.io.Buffer;
import org.eclipse.jetty.io.ByteArrayBuffer;

/**
 * Created by wanghm on 2014/12/15.
 */
public class HttpSchemes {
    public final static String
            HTTP ="http",
            HTTPS="https";

    public final static Buffer
            HTTP_BUFFER = new ByteArrayBuffer(HTTP),
            HTTPS_BUFFER = new ByteArrayBuffer(HTTPS);
}
