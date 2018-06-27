package com.gaofei.Thread;

import java.util.concurrent.SynchronousQueue;

/**
 * 这个实验证明了SynchronousQueue确实本身不存储内容，直接将内容给到另一个线程，
 * 另一个线程接受之前，所有put操作将阻塞
 * 没有线程take的时候，所有的put都将阻塞。
 * Created by GaoQingming on 2018/6/14 0014.
 */
public class SynchronousQueueTest {
    static SynchronousQueue<String> synchronousQueue = new SynchronousQueue(true);

    public static void main(String[] args) {
        PutThread putThread = new PutThread(synchronousQueue);
        PutThread putThread2 = new PutThread(synchronousQueue);
        TakeThread takeThread = new TakeThread(synchronousQueue);
        putThread.start();
        putThread2.start();
        takeThread.start();
    }


}
class PutThread extends Thread {
    private SynchronousQueue<String> synchronousQueue;
    public PutThread(SynchronousQueue synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            try {
                synchronousQueue.put("i:" + i);
                System.out.println("i put " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TakeThread extends Thread {
    private SynchronousQueue<String> synchronousQueue;
    public TakeThread(SynchronousQueue synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                String s = synchronousQueue.take();
                Thread.sleep(3000);
                System.out.println("i take " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}