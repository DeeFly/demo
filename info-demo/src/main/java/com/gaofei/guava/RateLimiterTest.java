package com.gaofei.guava;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author yichang
 * @date 2020/07/08
 */
public class RateLimiterTest {
    static RateLimiter rateLimiter = RateLimiter.create(7);


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //如果获得令牌指令，则执行业务逻辑
                    if (rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                        System.out.println("执行业务逻辑");
                    } else {
                        System.out.println("限流");
                    }
                }
            }).start();
        }

    }
}
