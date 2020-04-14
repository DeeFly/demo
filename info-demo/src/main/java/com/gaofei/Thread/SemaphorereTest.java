package com.gaofei.Thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSON;

public class SemaphorereTest {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Map<String, Object> map = new Hashtable<>();
        map.put("key1", "{\"activityPrice\":17500,\"outLatestRecord\":\"\",\"priceLevel\":{\"estimatedOrderPrice\":16621,\"minOrderPrice\":15800,\"pricebilityLevel\":3},\"waitConfirm\":0}");
        System.out.println(JSON.toJSONString(map));
    }
}
