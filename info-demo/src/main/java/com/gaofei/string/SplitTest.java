package com.gaofei.string;

import java.util.Arrays;

/**
 * 测试结果：split中可以使用regex
 * Created by yichang on 2019/5/5
 */
public class SplitTest {
    public static void main(String[] args) {
        String s = "111,2221,333 444 555";
        String[] ss = s.split(",| ");
        Arrays.stream(ss).forEach(System.out::println);
    }
}
