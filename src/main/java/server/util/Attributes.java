package server.util;

import java.util.Enumeration;

/**
 * Created by wanghm on 2014/12/8.
 */
public interface Attributes {
    public void removeAttr(String name);
    public void setAttr(String name,Object attr);
    public Object getAttr(String name);
    public Enumeration<String> getAttrs();
    public void clearAttrs();
}
