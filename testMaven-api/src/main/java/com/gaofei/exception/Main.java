package com.gaofei.exception;

/**
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            int i = 10/0;
        } catch (Exception e) {
            System.out.println("cause:" + e.getCause());
            System.out.println("toString:" + e.toString());
            System.out.println("getMessage:" + e.getMessage());
            System.out.println("e:" + e);
        }
    }
}
