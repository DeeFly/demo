package com.gaofei.map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by GaoQingming on 2018/8/13 0013.
 */
public class MultiValueMapMain {
    public static void main(String[] args) {
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("key1","value1");
        multiValueMap.add("key2","value2");
        multiValueMap.add("key2","value2");
        multiValueMap.add("key3","value3");
        multiValueMap.add("key3","value3");
        multiValueMap.remove("key3","value3");
        multiValueMap.entrySet().forEach(entity -> System.out.println(entity.getKey() + ": " + entity.getValue()));
    }

}
