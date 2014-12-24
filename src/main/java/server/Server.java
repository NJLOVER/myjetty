package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.jmx.HandlerWrapper;
import server.util.Attributes;
import server.util.component.Container;
import server.util.thread.ThreadPool;
import sun.font.AttributeMap;

/**
 * Created by wanghm on 2014/12/9.
 */
public class Server extends HandlerWrapper implements Attributes {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private final Container _container = new Container();
    private final AttributeMap attributeMap = new AttributeMap();
    private ThreadPool _threadPool;
    private Connector[] _connectiontors;
    private SessionIdManager sessionIdManager;
    private boolean _sendServerVesion = true;
    private boolean _sendDataHeader = true;
    private int graceful = 0;
    private boolean _stopAtShutDown;
    private boolean _dumpAfterStart = false;
    private boolean _dumpBeforeStop=false;
    private boolean _uncheckedPrintWriter=false;

    public Server()
    {
        setServer(this);
    }
    public Server(int port){
        setServer(this);
        Connector connector = new
    }

    public ThreadPool getThreadPool()
    {
        return _threadPool;
    }
}
