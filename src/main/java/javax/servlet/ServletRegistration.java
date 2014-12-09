package javax.servlet;

import javax.servlet.http.ServletResponse;
import java.util.Collection;
import java.util.Set;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface ServletRegistration extends Registration {

    public Set<String> addMapping(String... urlPatterns);

    public Collection<String> getMapping();

    public String getRunAsRole();

    interface Dynamic extends ServletRegistration,Registration.Dynamic{
        public void setLoadOnStartup(int loadOnStartup);

        //todo ServletSecurityElement 暂时没写
        //public Set<String> setServletSecurity(ServletSecurityElement constraint);

        public void setMultipartConfig(
                MultipartConfigElement multipartConfig);

        public void setRunAsRole(String roleName);

    }
}
