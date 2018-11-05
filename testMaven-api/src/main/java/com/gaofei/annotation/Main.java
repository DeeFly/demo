package com.gaofei.annotation;

/**
 * Created by GaoQingming on 2018/10/15 0015.
 */
public class Main {
    public static void main(String[] args) {
        DefaultHandler defaultHandler = new DefaultHandler();
        System.out.println(defaultHandler.getShardingColumn());
        System.out.println(defaultHandler.getShardingCount());
    }
}
