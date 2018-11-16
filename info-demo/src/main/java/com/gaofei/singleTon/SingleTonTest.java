package com.gaofei.singleTon;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 想试试DCL（双重检查加锁）单例模式的创建 的bug，跑了两个小时没成功
 * Created by GaoQingming on 2018/6/27 0027.
 */
public class SingleTonTest {
    private int i;
    public static SingleTonTest singleTonTest;

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    private SingleTonTest() {
        //try {
        //    Thread.sleep(5);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        i = 10;
    }

    public static SingleTonTest getSingleTonTest() {
        if (singleTonTest == null) {
            synchronized (SingleTonTest.class) {
                if (singleTonTest == null) {
                    singleTonTest = new SingleTonTest();
                }
            }
        }
        return singleTonTest;
    }

    public void printI() {
        if (i == 0) {
            System.out.println("等于0退出..............................");
            System.exit(0);
        }
        System.out.println(i);
    }

    public static void main(String[] args) {

        while (true) {
            CountDownLatch countDownLatch = new CountDownLatch(2);


            fixedThreadPool.execute(() -> {
                System.out.println("thread 1 start");
                SingleTonTest singleTonTest = SingleTonTest.getSingleTonTest();
                countDownLatch.countDown();
            });

            fixedThreadPool.execute(() -> {
                try {
                    System.out.println("thread 2 start");
                    SingleTonTest singleTonTest2 = SingleTonTest.getSingleTonTest();
                    singleTonTest2.printI();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常退出");
                    System.exit(0);
                } finally {
                    countDownLatch.countDown();
                }
            });

            try {
                countDownLatch.await();
                SingleTonTest.singleTonTest = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
