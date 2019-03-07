package com.gaofei.Thread;

import java.util.List;
import java.util.concurrent.*;

/**
 * 使用 new SynchronousQueue的时候，来任务的时候，只要线程数未到达maximumPoolSize，就会创建新的线程
 * SynchronousQueue不存储任务，而是直接交付给线程池中的线程执行，所以如果线上数达到线程池上限且都在工作，新进的任务会执行丢弃策略。
 * 而如果使用LinkedBlockingQueue的时候，只有队列满了以后，才会创建大于corePoolSize的线程数。
 *
 * 注意：工厂一定要接受r（Runnable），任务，不然会把任务丢弃。
 * Created by GaoQingming on 2019/3/6 0006.
 */
public class ThreadCountInThreadPoolTest {
    private static int threadCount = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(4, 10, 20, TimeUnit.SECONDS, new SynchronousQueue<>(),
                (r) -> new Thread(r, "MyThread" + String.valueOf(++threadCount)),
                (r, executor) -> {
                    System.out.println("over flow !");
                });

        Runnable runnable = () -> {
            System.out.println("--");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--");
            System.out.println(Thread.currentThread().getName());
        };

        for (int i = 0; i < 11; i++) {
            threadPoolExecutor.execute(runnable);
        }

        System.out.println(threadPoolExecutor.getActiveCount());

        System.exit(0);
    }
}

 class MyThreadPoolExecutor extends ThreadPoolExecutor{

     public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
         super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
     }

     public void shutdown() {
         System.out.println("shutdown called.");
         super.shutdown();
     }

     public List<Runnable> shutdownNow() {
         System.out.println("shutdownNow called.");
         return super.shutdownNow();
     }
 }
