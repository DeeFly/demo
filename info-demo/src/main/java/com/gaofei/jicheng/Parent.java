package com.gaofei.jicheng;

/**
 * Created by GaoQingming on 2018/1/24 0024.
 */
public class Parent {
    protected void a() {
        System.out.println("parent a");
        b();
    }
    protected void b() {
        System.out.println("parent b");
    }
}
