package javax.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface ServletRequest {
    public Object getAttribute(String name);
    public Enumeration<String> getAttributeNames();
    public String getCharacterEncoding();
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException;
    public int getContentLength();
    //获取mimetype
    public String getContentType();
    public ServletInputStream getInputStream();
    public String getParamter(String name);
    public Enumeration<String> getParamterNames();
    public String[] getParamterValues(String name);
    public Map<String,String[]> getParamterValues();
    public String getProtocol();
    public String getSchame();
    public String getServerName();
    public int getServerPort();
    public BufferedReader getReader();
    public String getRemoteAddr();
    public String getRemoteHost();
    public void setAttritute(String name,Object o);
    public void removeAttribute(String name);
    public Locale getLocale();
    public Enumeration<Locale> getLocales();
    public boolean isSecure();
    public RequestDispatcher getRequestDispather(String path);

    //不建议使用,被ServletContext#getRealPath替代
    @Deprecated
    public String getRealPath(String path);

    public int getRemotePort();
    public String getLocalName();
    public int getLocalPort();
    public String getLocalAddr();
    public ServletContext gerServletContext();

}
