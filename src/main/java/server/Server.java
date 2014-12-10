package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.jmx.HandlerWrapper;
import server.util.Attributes;
import server.util.component.Container;

/**
 * Created by wanghm on 2014/12/9.
 */
public class Server extends HandlerWrapper implements Attributes {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private final Container _container = new Container();

}
