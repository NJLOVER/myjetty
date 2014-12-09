package javax.servlet;

import java.util.Collection;
import java.util.EnumSet;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface FilterRegistration extends Registration {

    public void addMappingForServletNames(
            EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... servletNames);

    public Collection<String> getServletNameMappings();

    public void addMappingForUrlPatterns(
            EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... urlPatterns);

    public Collection<String> getUrlPatternMappings();

    interface Dynamic extends FilterRegistration, Registration.Dynamic {
    }
}
