package server;

import server.util.component.Destroyable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanghm on 2014/12/8.
 */
public interface Handler extends LifeCycle,Destroyable {
    public void handle(String target, Request baseRequest,HttpServletRequest request,HttpServletResponse response);
    public void setServer(Server server);
    public Server getServer();
    public void destroy();
}
