package server.util.component;

import org.eclipse.jetty.util.component.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wanghm on 2014/12/10.
 */
public class AggregateLifeCycle extends AbstractLifeCycle implements Destroyable, Dumpable{
    private static Logger logger = LoggerFactory.getLogger(AggregateLifeCycle.class);

    private CopyOnWriteArrayList<Bean> _beans = new CopyOnWriteArrayList<Bean>();
    private boolean _started = false;

    private class Bean{
        final Object _bean;
        volatile boolean _managed = true;
        Bean(Object o){_bean = o;}
        public String toString()
        {
            return "{"+_bean+","+_managed+"}";
        }
    }
    @Override
    protected void doStart() throws Exception {
        for(Bean b :_beans){
            if(b._managed && b._bean instanceof LifeCycle){
                LifeCycle l = (LifeCycle)b;
                if(!l.isRunning()){
                    l.start();
                }
            }
        }
        _started = true;
        super.doStart();
    }
    @Override
    protected void doStop() throws Exception{
        _started = false;
        super.doStop();
        List<Bean> reverse = new ArrayList<Bean>(_beans);
        Collections.reverse(reverse);
        for(Bean b:reverse){
            if(b._managed && b._bean instanceof LifeCycle){
                LifeCycle l = (LifeCycle)b;
                if(l.isRunning()){
                    l.stop();
                }
            }
        }
    }

    @Override
    public void destroy() {
        List<Bean> reverse = new ArrayList<Bean>(_beans);
        Collections.reverse(reverse);
        for(Bean b :reverse){
            if(b._bean instanceof Destroyable && b._managed){
                Destroyable d = (Destroyable) b;
                d.destroy();
            }
        }
        _beans.clear();
    }

    public boolean contains(Object bean)
    {
        for (Bean b:_beans)
            if (b._bean==bean)
                return true;
        return false;
    }
    public boolean isManaged(Object bean)
    {
        for (Bean b:_beans)
            if (b._bean==bean)
                return b._managed;
        return false;
    }

    public boolean addBean(Object o,boolean managed){
        if(contains(o))
            return false;
        Bean b = new Bean(o);
        b._managed = managed;
        _beans.add(b);

        if(o instanceof LifeCycle){
            LifeCycle l = (LifeCycle)o;
            if(managed && _started){
                try {
                    l.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    public void manage(Object bean)
    {
        for (Bean b :_beans)
        {
            if (b._bean==bean)
            {
                b._managed=true;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void unmanage(Object bean)
    {
        for (Bean b :_beans)
        {
            if (b._bean==bean)
            {
                b._managed=false;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Object> getBeans()
    {
        return getBeans(Object.class);
    }

    public <T> List<T> getBeans(Class<T> clazz){
        ArrayList<T> beans = new ArrayList<T>();
        for(Bean b :_beans){
            if(clazz.isInstance(b)){
                beans.add((T)b._bean);
            }
        }
        return beans;
    }

    public <T> T getBean(Class<T> clazz)
    {
        for (Bean b:_beans)
        {
            if (clazz.isInstance(b._bean))
                return (T)b._bean;
        }

        return null;
    }

    public void clearBeans(){
        _beans.clear();
    }
    public boolean removeBean(Object o){
        Iterator<Bean> it = _beans.iterator();
        while(it.hasNext()){
            Bean b = it.next();
            if(b._bean == o){
                _beans.remove(b);
                return true;
            }
        }
        return false;
    }


    @Override
    public String dump() {
        return dump(this);
    }

    public static String dump(Dumpable dumpable){
        StringBuffer sb = new StringBuffer();
        try
        {
            dumpable.dump(sb,"");
        }
        catch (IOException e)
        {
            logger.warn("dump warn!-->{}",e);
        }
        return sb.toString();
    }

    protected void dumpThis(Appendable out) throws IOException
    {
        out.append(String.valueOf(this)).append(" - ").append(getState()).append("\n");
    }

    @Override
    public void dump(Appendable out, String indent) throws IOException {
        //todo 暂时不写,使用到再说
    }


}
