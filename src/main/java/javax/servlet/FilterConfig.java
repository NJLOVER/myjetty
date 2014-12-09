package javax.servlet;

import java.util.Enumeration;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface FilterConfig {
    public String getFilterName();
    public ServletContext getServletContext();
    public String getInitParameter(String name);
    public Enumeration<String> getInitParameters();
}
