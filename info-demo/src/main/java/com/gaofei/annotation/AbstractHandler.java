package com.gaofei.annotation;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/10/15 0015.
 */
public class AbstractHandler<T extends MyEntity> {

    private String shardingColumn;
    private int shardingCount;

    private Field shardField;

    //获取类中泛型的类型
    private ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
    private Class<T> entityClass = (Class<T>) type.getActualTypeArguments()[0];

    public AbstractHandler() {
        initShardInfo();
    }

    private void initShardInfo() {
        // 这种方式更简单
        // List<Field> fields = FieldUtils.getFieldsListWithAnnotation(entityClass, ShardingKey.class);

        //下面这种方式可以处理更复杂一点的问题
        final List<Field> shardFields = new ArrayList<>();
        ReflectionUtils.doWithFields(entityClass, field -> {
            if (field.getAnnotation(ShardingKey.class) != null) {
                shardFields.add(field);
            }
        });
        if (shardFields.size() > 1) {
            throw new RuntimeException("分片字段不唯一");
        }

        shardFields.forEach(field -> {
            ShardingKey annotation = field.getAnnotation(ShardingKey.class);
            if (annotation == null) {
                return;
            }
            this.shardingColumn = annotation.shardingColumn();
            this.shardingCount = annotation.shardingCount();
            this.shardField = field;
        });
    }

    public String getShardingColumn() {
        return shardingColumn;
    }

    public void setShardingColumn(String shardingColumn) {
        this.shardingColumn = shardingColumn;
    }

    public int getShardingCount() {
        return shardingCount;
    }

    public void setShardingCount(int shardingCount) {
        this.shardingCount = shardingCount;
    }
}
