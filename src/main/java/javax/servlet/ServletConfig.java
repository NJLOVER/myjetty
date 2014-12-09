package javax.servlet;

import java.util.Enumeration;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface ServletConfig {
    public String getServletName();
    public ServletContext getServletContext();
    //获取web.xml里面的init-param标签数据
    public String getInitParameter(String name);
    public Enumeration<String> getInitParameters();
}
