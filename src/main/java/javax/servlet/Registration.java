package javax.servlet;

import java.util.Map;
import java.util.Set;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface Registration {
    public String getName();
    public String getClassName();
    public boolean setInitParamter(String name,String value);
    public String getInitParamter(String name);
    public Set<String> setInitParamters(Map<String,String> initParamters);
    public Map<String,String> getInitParamter();

    interface Dynamic extends Registration{
        public void setAsyncSupported(boolean isAsyncSupported);
    }
}
