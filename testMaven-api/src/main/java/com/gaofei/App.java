package com.gaofei;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 102; i++) {
            list.add(i);
        }

        int size = list.size();
        for (int startIndex = 0; startIndex != size; ) {
            int endIndex = startIndex + 50 > size ? size : startIndex + 50;
            System.out.println(list.subList(startIndex, endIndex));
            startIndex = endIndex;
        }
    }
}
