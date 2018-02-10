package com.gaofei.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by GaoQingming on 2018/2/9 0009.
 */
public class FutureTaskTest {
    private final FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
        public String call() throws Exception {
            return null;
        }
    });
}
