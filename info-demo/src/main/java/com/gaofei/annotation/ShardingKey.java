package com.gaofei.annotation;

import java.lang.annotation.*;

/**
 * Created by GaoQingming on 2018/10/15 0015.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ShardingKey {
    String shardingColumn() default "";
    int shardingCount() default 256;
}
