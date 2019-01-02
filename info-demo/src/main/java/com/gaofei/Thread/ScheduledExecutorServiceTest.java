package com.gaofei.Thread;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by GaoQingming on 2018/12/24 0024.
 */
public class ScheduledExecutorServiceTest {
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void testThreadException() {
        //这个方法不能遇到异常，遇到异常线程池里面的线程就挂了，不会增加。
        executor.scheduleAtFixedRate(() -> {
                    System.out.println("invoked ...");
                    int i = 10 / 0;
                    System.out.println(i);
                },
                0,
                1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        testThreadException();
        new ArrayList<>().stream().filter((a) -> a != null);
    }
}
