package server;

import org.eclipse.jetty.io.AbstractConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanghm on 2014/12/10.
 */
public class AbstractHttpConnection implements AbstractConnection {
    private static Logger logger = LoggerFactory.getLogger(AbstractHttpConnection.class);

    private static final int UNKNOWN = -2;
    private static final ThreadLocal<AbstractHttpConnection> __currentConnection  = new ThreadLocal<AbstractHttpConnection>();
    private int _requests;




}
