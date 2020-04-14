package com.gaofei.factory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author qingming.gqm
 * @date 2020/4/14
 */
public class AbstractFactory<T extends Supporter> implements ApplicationContextAware, InitializingBean {

    private Map<Integer, T> strategies = new HashMap<>();
    private ApplicationContext applicationContext;
    private Class<T> clazz = null;


    public T getByType(Integer type) {
        return strategies.get(type);
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, T> strategyMap = applicationContext.getBeansOfType(clazz);
        if (MapUtils.isEmpty(strategyMap)) {
            return;
        }

        strategyMap.entrySet().forEach(entry -> {
            T supporter = entry.getValue();
            List<Integer> supportTypeSet = supporter.support();
            if (CollectionUtils.isEmpty(supportTypeSet)) {
                throw new RuntimeException(supporter.getClass().getName() + "未指明支持的类型");
            }
            supportTypeSet.forEach(type -> strategies.put(type, supporter));
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    {
        Type type = getClass().getGenericSuperclass();
        if( type instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType)type;
            Type claz = pType.getActualTypeArguments()[0];
            if( claz instanceof Class ){
                this.clazz = (Class<T>) claz;
            }
        }
    }
}
