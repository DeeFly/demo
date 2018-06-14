package com.gaofei.thread_shujujiegou;

import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by GaoQingming on 2018/2/28 0028.
 */
public class Main {
    public static void main(String[] args) {
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("","");
        linkedHashMap.get("");
        try {
            linkedBlockingQueue.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
