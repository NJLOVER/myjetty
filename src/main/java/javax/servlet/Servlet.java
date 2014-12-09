package javax.servlet;

import javax.servlet.http.ServletRequest;
import javax.servlet.http.ServletResponse;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface Servlet {
    public void init(ServletConfig servletConfig);
    public ServletConfig getServletConfig();
    public void service(ServletRequest request,ServletResponse response);
    public String getServletInfo();
    public void destroy();
}
