package com.gaofei.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by GaoQingming on 2018/1/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        //下面这种写法，遍历输出的顺序只和插入顺序有关系，即使中间有get或者覆盖操作，都不会影响遍历输出的顺序
        LinkedHashMap<String,String> map1 = new LinkedHashMap();
        map1.put("key1","value1");
        map1.put("key3","value3");
        map1.put("key2","value2");
        map1.put("key4","value4");
        map1.put("key5","value5");
        map1.put("key2","testValue");
        String s = map1.get("key3");
        Iterator<Map.Entry<String,String>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
    }
}
