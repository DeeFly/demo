package com.gaofei.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 可以使用return跳出本次循环，不能用continue或者break;
 * Created by GaoQingming on 2018/6/27 0027.
 */
public class SkipLoopTest {

    public static void main(String[] args) {
        String[] strings = {"1111","222","333","444","5555"};
        List<String> stringList = Arrays.asList(strings);
        stringList.forEach(s -> {
            if ("333".equals(s)) {
                return;
            }
            System.out.println(s);
        });
    }
}
