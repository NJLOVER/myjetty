package server;

import http.HttpBuffers;
import http.HttpSchemes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.util.component.AggregateLifeCycle;
import server.util.component.Dumpable;

/**
 * Created by wanghm on 2014/12/15.
 */
public abstract class AbstractConnector extends AggregateLifeCycle implements HttpBuffers, Connector, Dumpable {
    private static Logger logger = LoggerFactory.getLogger(AbstractConnector.class);

    private String _name;
    private Server _server;
    private String _host;
    private int _port = 0;
    private String _integralScheme = HttpSchemes.HTTP;
    private int _integralPort = 0;
    private String _confidentialScheme = HttpSchemes.HTTPS;
    private int _confidentialPort = 0;
    private int _acceptQueueSize = 0
    private int _acceptors = 1;
    private int _acceptorPriorityOffset = 0;
    private boolean _useDNS;
    private boolean _forwarded;
    private String _hostHeader;

    ;


}
