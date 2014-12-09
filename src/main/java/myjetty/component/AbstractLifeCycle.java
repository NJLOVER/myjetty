package myjetty.component;

import myjetty.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wanghm on 2014/12/8.
 */
public class AbstractLifeCycle implements LifeCycle {

    private Logger logger = LoggerFactory.getLogger(AbstractLifeCycle.class);
    public static final String STOPPED="STOPPED";
    public static final String FAILED="FAILED";
    public static final String STARTING="STARTING";
    public static final String STARTED="STARTED";
    public static final String STOPPING="STOPPING";
    public static final String RUNNING="RUNNING";

    private final Object _lock = new Object();
    private final int _FAILED=-1,_STOPPED = 0,_STARTING = 1,_STARTED = 2,_STOPPING = 3;
    private volatile int _STATE = _STOPPED;

    protected final CopyOnWriteArrayList<Listener>_listeners = new CopyOnWriteArrayList<Listener>();

    @Override
    public void start() throws Exception {
        synchronized (_lock){
            try{
                if(_STATE == _STARTED || _STATE == _STARTING){
                    return;
                }
                setSarting();
                doStart();
                setStarted();
            }catch (Exception e){
                setFailed(e);
                throw e;
            }catch (Error e){
                setFailed(e);
                throw e;
            }
        }
    }

    protected void doStart(){

    }

    private void setStarted(){
        _STATE = _STARTED;
        logger.debug("Started {}",this);
        for(Listener listener : _listeners){
            listener.lifeCycleStarted(this);
        }
    }

    private void setSarting(){
        logger.debug("starting {}",this);
        _STATE = _STARTING;
        for(Listener listener : _listeners){
            listener.lifeCycleStarting(this);
        }
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public boolean isFailed() {
        return false;
    }

    @Override
    public void addLifeCycleListener(Listener listener) {

    }
    private void setFailed(Throwable th){
        _STATE = _FAILED;
        logger.warn(FAILED+" " + this+": "+th,th);
        for(Listener listener : _listeners)
            listener.lifeCycleFailure(this,th);
    }
}
