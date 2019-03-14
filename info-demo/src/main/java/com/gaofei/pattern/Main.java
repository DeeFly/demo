package com.gaofei.pattern;

/**
 * Created by GaoQingming on 2019/3/14 0014.
 */
public class Main {
    public static void main(String[] args) {
        String s = "figure           skating";
        String s2 = "figure skating";
        System.out.println(s2.equals(s.replaceAll(" {2,}", " ")));
    }
}
