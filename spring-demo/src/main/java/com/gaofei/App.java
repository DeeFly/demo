package com.gaofei;

import java.util.HashMap;
import java.util.Map;

import com.gaofei.qlexpress.ExpressSpringBeanRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/application-context.xml");
        ExpressSpringBeanRunner expressSpringBeanRunner = (ExpressSpringBeanRunner)applicationContext.getBean("expressSpringBeanRunner");
        Map<String, Object> params = new HashMap<>(1);
        params.put("value", 2);
        Object o = expressSpringBeanRunner.executeExpress("functionService.calculate(value)", params);
        System.out.println(o);
    }
}
