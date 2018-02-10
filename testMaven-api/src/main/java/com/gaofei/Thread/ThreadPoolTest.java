package com.gaofei.Thread;

import java.util.concurrent.*;

/**
 * Created by GaoQingming on 2018/2/4 0004.
 */
public class ThreadPoolTest {
    //下面这个new ThreadPoolExecutor 没有做过实验，也不太确定用途
    private BlockingQueue queue = new LinkedBlockingQueue(10);
    private ThreadFactory factory = new ThreadFactory() {
        public Thread newThread(Runnable r) {
            return null;
        }
    };
    private RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    };
    private ExecutorService executorService = new ThreadPoolExecutor(4, 10, 60000, TimeUnit.MILLISECONDS, queue, factory,handler);
    ////////

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

    public void cachedThreadPoolTest() {
        cachedThreadPool.execute(new Runnable() {
            public void run() {
                //do nothing
            }
        });
    }

    public static void main(String[] args) {

    }
}
