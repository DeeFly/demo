package com.gaofei;

import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {
    private static final String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
    public <T> void getAnnotations(Class<T> tClass) {
        Method[] methods = tClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Test2 test2 = method.getAnnotation(Test2.class);
            System.out.println(test2.description());
        }
    }

    public static String patternKeyFilter(String s) {
        for (String key : fbsArr) {
            if (s.contains(key)) {
                s = s.replace(key, "");
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "g((((((((";
        String s2 = s.replace("(", "");
        System.out.println(s2.length());
        System.out.println(s2);
    }
}
