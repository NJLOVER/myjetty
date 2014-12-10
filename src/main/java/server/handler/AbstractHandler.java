package server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.Handler;
import server.Server;
import server.util.component.AggregateLifeCycle;

/**
 * Created by wanghm on 2014/12/10.
 */
public abstract class AbstractHandler extends AggregateLifeCycle implements Handler {
    private static Logger logger = LoggerFactory.getLogger(AbstractHandler.class);

    private Server _server;

    public AbstractHandler(){}

    public void doStart() throws Exception {
        logger.debug("starting {}", this);
        super.doStart();
    }

    protected void doStop() throws Exception
    {
        logger.debug("stopping {}",this);
        super.doStop();
    }

    public void setServer(Server server){
        //todo 取消老server下的container 与 handler的关联,新增新server的container与handler的关联
    }

}
