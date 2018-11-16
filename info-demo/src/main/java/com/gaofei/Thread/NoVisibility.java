package com.gaofei.Thread;

/**
 * Created by GaoQingming on 2018/2/8 0008.
 */
public class NoVisibility {
    public static boolean ready;
    public static int number;
    public static class ReaderThread extends  Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static boolean isReady() {
        return ready;
    }

    public static void setReady(boolean ready) {
        NoVisibility.ready = ready;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        NoVisibility.number = number;
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        ready = true;
        number = 42;
    }
}
