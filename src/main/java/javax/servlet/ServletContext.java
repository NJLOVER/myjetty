package javax.servlet;

import javax.servlet.descriptor.JspConfigDescriptor;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface ServletContext {
    public static final String TEMPDIR = "javax.servlet.context.tempdir";
    public static final String ORDERED_LIBS =
            "javax.servlet.context.orderedLibs";

    public String getContextPath();
    public ServletContext getContext(String uriPath);
    public int getMajorVersion();
    public int getMinorVersion();
    public int getEffectiveVersion();
    /*
     * 返回特殊文件的mimeType,include <code>text/html</code> and <code>image/gif</code>
     */
    public String getMimeType(String file);
    public Set<String> getResourcePath(String path);
    public URL getResource(String path) throws MalformedURLException;
    public InputStream getResourceAsStream(String path);
    public RequestDispatcher getRequestDispatcher(String path);
    public RequestDispatcher getNameDispatcher(String name);
    public Servlet getServlet(String name);
    public Enumeration<Servlet> getServlets();
    public Enumeration<String> getServletNames();
    public void log(String msg);
    public void log(Exception e,String msg);
    public void log(String msg,Throwable th);
    public String getRealPath(String path);
    public String getServerInfo();
    //获取web.xml里面的context-param标签数据
    public String getInitParamter(String name);
    public Enumeration<String> getInitParamterNames();
    public boolean setInitParamter(String name,String value);
    public Object getAttribute(String name);
    public Enumeration<String> getAttributeNames();
    public void setAttribute(String name,Object obj);
    public void removeAttribute(String name);
    public String getServletContextName();

    public ServletRegistration.Dynamic addServlet(String name,String className);

    public ServletRegistration.Dynamic addServlet(String name,Servlet servlet);

    public ServletRegistration.Dynamic addServlet(String name,Class<? extends Servlet> servletClass);

    public <T extends Servlet> T createServlet(Class<T> clazz);

    public ServletRegistration getServletRegistration(String servletName);

    public Map<String,? extends ServletRegistration> getServletRegistration();

    public FilterRegistration.Dynamic addFilter(String filterName,String className);

    public FilterRegistration.Dynamic addFilter(
            String filterName, Filter filter);

    public FilterRegistration.Dynamic addFilter(String filterName,
                                                Class <? extends Filter> filterClass);

    public <T extends Filter> T createFilter(Class<T> clazz)
            throws ServletException;

    public FilterRegistration getFilterRegistration(String filterName);

    public Map<String, ? extends FilterRegistration> getFilterRegistrations();

    public SessionCookieConfig getSessionCookieConfig();

    public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes);

    public Set<SessionTrackingMode> getDefaultSessionTrackingModes();

    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes();

    public void addListener(String className);

    public <T extends EventListener> void addListener(T t);

    public void addListener(Class <? extends EventListener> listenerClass);

    public <T extends EventListener> T createListener(Class<T> clazz)
            throws ServletException;

    public JspConfigDescriptor getJspConfigDescriptor();

    public ClassLoader getClassLoader();

    public void declareRoles(String... roleNames);
}
