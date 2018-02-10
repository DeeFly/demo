package com.gaofei.ConcatNullString;

/**
 * Created by GaoQingming on 2018/1/4 0004.
 */
public class Main {
    public static void main(String[] args) {
        String s = new StringBuilder("SRResourceStatisticsDTO-aC:").append(null + "").toString();
        System.out.println(s);
    }
}
