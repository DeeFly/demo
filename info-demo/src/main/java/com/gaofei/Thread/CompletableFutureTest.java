package com.gaofei.Thread;


import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 结果是有序的，按提交的顺序返回结果
 * Created by GaoQingming on 2019/1/24 0024.
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Shop> shops = new ArrayList<>(10);
        shops.add(new Shop("1"));
        shops.add(new Shop("2"));
        shops.add(new Shop("3"));
        shops.add(new Shop("4"));
        shops.add(new Shop("5"));
        shops.add(new Shop("6"));
        shops.add(new Shop("7"));
        shops.add(new Shop("8"));
        shops.add(new Shop("9"));
        shops.add(new Shop("10"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<CompletableFuture> completableFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(), executorService)).collect(Collectors.toList());
        List<String> result = completableFutures.stream().map(CompletableFuture<String>::join).collect(Collectors.toList());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        result.forEach(System.out::println);
    }



    static class Shop{
        private String name;
        public Shop(String name) {
            this.name = name;
        }

        public String getPrice() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Random().nextInt() + "  " + this.name;
        }
    }
}
