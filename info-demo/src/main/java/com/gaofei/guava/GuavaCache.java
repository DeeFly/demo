package com.gaofei.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author yichang
 * @date 2020/06/05
 */
public class GuavaCache {
    private LoadingCache<Long, String> cache = CacheBuilder.newBuilder().
        maximumSize(1024).expireAfterWrite(30, TimeUnit.SECONDS).build(
        new CacheLoader<Long, String>() {
            @Override
            public String load(Long activityId) {
                return activityId + "";
            }
        }
    );

    public String getFromCache(Long activity) {
        try {
            return cache.get(activity);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
