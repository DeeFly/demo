package com.gaofei.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GaoQingming on 2018/8/28 0028.
 */
public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        lock.lock();
        lock.lock();

        new MyThread(lock, "thread1").start();
        new MyThread(lock, "thread2").start();
    }

    private static class MyThread extends Thread {
        Lock lock;
        MyThread(Lock lock, String name) {
            super(name);
            this.lock = lock;
        }
        @Override
        public void run() {
            super.run();
                //lock.lock()不响应中断
                // lock.lockInterruptibly可以响应中断
                lock.lock();
            System.out.println(Thread.currentThread().getName());
        }
    }
}


