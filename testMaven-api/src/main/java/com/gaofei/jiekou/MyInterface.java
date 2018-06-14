package com.gaofei.jiekou;

/**
 * Created by GaoQingming on 2018/6/12 0012.
 */
public interface MyInterface {
    void test1();

    default void test2() {
        System.out.println("lll");
        test3();
    }

    static void test3() {
        System.out.println("static");
    }
}

