package com.gaofei.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GaoQingming on 2017/12/27 0027.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService cachedPool = Executors.newFixedThreadPool(10);
        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedPool.submit(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            sdf.format(new Date());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            });
        }
    }
}
