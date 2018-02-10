package com.gaofei;

import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {

    public <T> void getAnnotations(Class<T> tClass) {
        Method[] methods = tClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Test2 test2 = method.getAnnotation(Test2.class);
            System.out.println(test2.description());
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.setTest2("for child");
        child.setTest1("for parent");
        System.out.println(child.getTest1());
    }
}
