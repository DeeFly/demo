package com.gaofei.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * 不会改变传进方法之前的引用的地址。
 * 所以尽量不要把一个引用传递到另一个方法然后把它赋值为别的引用，这样还不如在被调用的方法内创建一个清晰。
 * Created by GaoQingming on 2018/4/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        String s = "outter";
        changeString(s);
        System.out.println(s);

        List<String> list = new ArrayList<>();
        list.add("1");
        changeList(list);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    private static void changeList(List<String> list) {
        list = new ArrayList<>();
        list.add("10");
    }

    private static void changeString(String s ) {
        s = "aferChange";
    }
}
