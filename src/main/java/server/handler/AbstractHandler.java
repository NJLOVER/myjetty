package server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.Handler;
import server.Server;

/**
 * Created by wanghm on 2014/12/10.
 */
public abstract class AbstractHandler implements Handler {
    private static Logger logger = LoggerFactory.getLogger(AbstractHandler.class);

    private Server _server;

    public AbstractHandler(){}


}
