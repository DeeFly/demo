package com.gaofei.main;

/**
 *
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        Integer i1;
        Integer i2 = null;
        i1 = true? i2 : 1;  //这样写是有问题的
        System.out.println(i1);
    }
}
