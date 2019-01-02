package com.gaofei;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by GaoQingming on 2018/12/24 0024.
 */
public class ScheduledExecutorServiceTest {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    @Test
    public void testThreadException() {
        executor.schedule(() -> {
            System.out.println("invoked ...");
            int i = 10 / 0;
            System.out.println(i);
        },
                1, TimeUnit.SECONDS);
    }


}
