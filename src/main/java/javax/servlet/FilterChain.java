package javax.servlet;

import java.io.IOException;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface FilterChain {
    public void doFilter(ServletRequest request,ServletResponse response) throws IOException, ServletException;
}
