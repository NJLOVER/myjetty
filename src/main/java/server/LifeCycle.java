package server;

import server.util.EventListener;

/**
 * Created by wanghm on 2014/12/8.
 */
public interface LifeCycle {
    public void start() throws Exception;

    public void stop() throws Exception;

    public boolean isRunning();

    public boolean isStarted();

    public boolean isStopping();

    public boolean isStopped();

    public boolean isFailed();

    public void addLifeCycleListener(Listener listener);

    public interface Listener extends EventListener {
        public void lifeCycleStarting(LifeCycle life);
        public void lifeCycleStarted(LifeCycle life);
        public void lifeCycleFailure(LifeCycle life,Throwable throwable);
        public void lifeCycleStopped(LifeCycle life);
        public void lifeCycleStopping(LifeCycle life);
    }
}
