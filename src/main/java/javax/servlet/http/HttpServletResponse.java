package javax.servlet.http;

import javax.servlet.ServletResponse;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface HttpServletResponse extends ServletResponse {
    public void addCookie(Cookie cookie);

    public boolean containHeader(String name);

    public String encodeURL(String url);

    public String encodeRedirectURL(String url);


}
