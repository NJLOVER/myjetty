package server.util.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.util.EventListener;

import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wanghm on 2014/12/10.
 */
public class Container {
    private static Logger logger = LoggerFactory.getLogger(Container.class);
    private final CopyOnWriteArrayList<Container.Listener> _listeners = new CopyOnWriteArrayList<Listener>();

    public void addEventListener(Listener listener){
        _listeners.add(listener);
    }

    public void removeEventListener(Listener listener){
        _listeners.remove(listener);
    }

    private void add(Object parent,Object child,String relationship){
        if(logger.isDebugEnabled())
            logger.debug("Container "+parent+" + "+child+" as "+relationship);
        if(_listeners != null){
            Relationship event = new Relationship(this,parent,child,relationship);
            for(int i=0;i<_listeners.size();i++){
                _listeners.get(i).add(event);
            }
        }
    }



    public static class Relationship{
        private final WeakReference<Object> _parent;
        private final WeakReference<Object> _child;
        private String _relationship;
        private Container _container;

        public Relationship(Container container, Object parent,Object child, String relationship){
            _container=container;
            _parent=new WeakReference<Object>(parent);
            _child=new WeakReference<Object>(child);
            _relationship=relationship;
        }
        public Container getContainer()
        {
            return _container;
        }

        public Object getChild()
        {
            return _child.get();
        }

        public Object getParent()
        {
            return _parent.get();
        }

        public String getRelationship()
        {
            return _relationship;
        }

        @Override
        public String toString()
        {
            return _parent+"---"+_relationship+"-->"+_child;
        }

        @Override
        public int hashCode()
        {
            return _parent.hashCode()+_child.hashCode()+_relationship.hashCode();
        }

        @Override
        public boolean equals(Object o)
        {
            if (o==null || !(o instanceof Relationship))
                return false;
            Relationship r = (Relationship)o;
            return r._parent.get()==_parent.get() && r._child.get()==_child.get() && r._relationship.equals(_relationship);
        }
    }
    public interface Listener extends EventListener{
        public void addBean(Object bean);
        public void removeBean(Object bean);
        public void add(Container.Relationship relationship);
        public void remove(Container.Relationship relationship);
    }
}
