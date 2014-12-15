package server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wanghm on 2014/12/15.
 */
public interface SessionIdManager extends LifeCycle{
    public boolean idInUse(String id);

    public void addSession(HttpSession session);

    public void removeSession(HttpSession session);

    public void invalidateAll(String id);

    public String newSessionId(HttpServletRequest request,long createId);

    public String getWorkName();

    public String getClusterId(String nodeId);

    public String getNodeId(String clusterId,HttpServletRequest request);
}
