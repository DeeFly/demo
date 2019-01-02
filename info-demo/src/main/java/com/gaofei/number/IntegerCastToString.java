package com.gaofei.number;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
 * at com.gaofei.App.main(App.java:14)
 * Created by GaoQingming on 2019/1/2 0002.
 */
public class IntegerCastToString {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("charCount", 2);
        String s = (String)map.get("charCount");
        System.out.println(s);
    }
}
