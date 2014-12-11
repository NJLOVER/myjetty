package server.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghm on 2014/12/11.
 */
public class AttributesMap implements Attributes {

    protected final Map<String ,Object> _map;

    public AttributesMap(){
        _map = new HashMap<String, Object>();
    }

    public AttributesMap(Map<String ,Object> map){
        _map = map;
    }

    public AttributesMap(AttributesMap map)
    {
        _map=new HashMap<String,Object>(map._map);
    }


    @Override
    public void removeAttr(String name) {
        _map.remove(name);
    }

    @Override
    public void setAttr(String name, Object attr) {
        if(attr == null)
            _map.remove(name);
        else
            _map.put(name,attr);
    }

    @Override
    public Object getAttr(String name) {
        return _map.get(name);
    }

    @Override
    public Enumeration<String> getAttrs() {
        return Collections.enumeration(_map.keySet());
    }

    @Override
    public void clearAttrs() {
        _map.clear();
    }
}
