package com.gaofei.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 最大值+1之后变成了正数的有符号最小值。
 * Created by GaoQingming on 2018/11/21 0021.
 */
public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
        System.out.println(atomicInteger);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }
}
