package com.gaofei.main;

import java.util.Date;

/**
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        Date date = new Date(0);
        System.out.println(date.toLocaleString());
        Long l = null;
        System.out.println(l != 1L);
    }
}
