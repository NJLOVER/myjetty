package server.util.thread;

/**
 * Created by wanghm on 2014/12/11.
 */
public interface ThreadPool {
    public boolean dispath(Runnable job);

    public void join()throws InterruptedException;

    public int getThreads();
    //获取空闲线程数
    public int getIdleThreads();

    public boolean isLowOnThreads();

    public interface SizedThreadPool extends ThreadPool{
        public int getMinThreads();
        public int getMaxThreads();
        public void setMinThreads(int threads);
        public void setMaxThreads(int threads);
    }
}
