package com.gaofei.Thread;

/**
 * 安全发布还是没搞懂
 *
 * Created by GaoQingming on 2018/3/12 0012.
 */
public class SafeInitiate {
    public static SafeInitiate safeInitiate;
    public static void main(String[] args) {
        Thread threada = new Thread() {
            @Override
            public void run() {
                if (safeInitiate == null) {
                    safeInitiate = new SafeInitiate();
                }
                System.out.println("Thread aaaaa :" + safeInitiate.getA() + " B:" + safeInitiate.getB());
            }
        };

        Thread threadb = new Thread() {
            @Override
            public void run() {
                if (safeInitiate == null) {
                    safeInitiate = new SafeInitiate();
                }
                System.out.println("Thread bbbbbb :" + safeInitiate.getA() + " B:" + safeInitiate.getB());
            }
        };

        threada.start();
        threadb.start();
    }



    public SafeInitiate() {
        a = 100;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b = 50;
    }

    private int a ;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
