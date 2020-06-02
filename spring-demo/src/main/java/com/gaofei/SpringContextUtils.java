package com.gaofei;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yichang
 * @date 2020/06/02
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 根据bean的name来查找对象
     * @param beanName 接口名称 ：
     * @return
     */
    public static <T> T getBean(String beanName) {
        if(StringUtils.isBlank(beanName)) {
            return null;
        }
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> requiredType) {
        if (StringUtils.isBlank(beanName)) {
            return null;
        }
        return applicationContext.getBean(beanName, requiredType);
    }

    /**
     * 根据bean的CLass类类型来查找对象
     * @param requiredType
     * @return
     */
    public static <T> T getBeanByClass(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
