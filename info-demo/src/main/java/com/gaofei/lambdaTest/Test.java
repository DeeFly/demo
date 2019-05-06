package com.gaofei.lambdaTest;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by yichang on 2019/5/6
 */
public class Test {
    public static void main(String[] args) {
        String[] strings = {"3df", "dsfsdg", "sdf"};
        System.out.println(Arrays.stream(strings).collect(Collectors.joining(", ")));
    }
}
