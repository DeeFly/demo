package com.gaofei.lambdaTest;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by yichang on 2019/5/6
 */
public class Test {
    public static void main(String[] args) {
        int i = 1;
        i = print(i);
        System.out.println(i);
    }

    private static int print(int i) {
        System.out.println(i++);
        return i;
    }

}
