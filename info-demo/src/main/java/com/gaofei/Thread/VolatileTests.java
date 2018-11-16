package com.gaofei.Thread;

/**
 * i变化了以后可以被另一个线程发现。没有加volatile
 * Created by GaoQingming on 2018/6/26 0026.
 */
public class VolatileTests {
    private int i = 0;

    public void testI() {
        while (true) {

            if (i == 0) {
                System.out.println("000000000");
            } else {
                System.out.println("1111111111111");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setI() {
        System.out.println("set IIIIIIIIIIIIIIIIIIIIIIIIII");
        i = 2;
        System.out.println("i =====" + i);
    }

    public static void main(String[] args) {
        VolatileTests volatileTests = new VolatileTests();
        new Thread() {
            @Override
            public void run() {
                super.run();
                volatileTests.testI();
            }
        }.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                super.run();
                volatileTests.setI();
            }
        }.start();
    }
}
