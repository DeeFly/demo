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

    //这个也不太理解
    //好像是一组计算的句柄。例如要下载多个图片，如果用ExecutorService的话，需要返回一个List，那么这样就是串行了。
    //而使用ExecutorCompletionService 就可以将一组任务分开执行，BlockingQueue中保存一组FutureTask，每一个FutureTask代表一个图片。
    //不过后来又看到了ExecutorService的invokeAll方法，参数为一组任务，返回一组Future （所以又不懂了）
    ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);



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

    //获取cpu处理器的数量
    int cpuCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
    }
}


/*//这种方式可以为单个线程设置异常处理器
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                throw new RuntimeException("test");
            }
        };
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        });
        thread.start();*/
