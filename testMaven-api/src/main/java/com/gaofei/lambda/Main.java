package com.gaofei.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by GaoQingming on 2018/3/20 0020.
 */
public class Main {
    public static void main(String[] args) {
        List<User> integerList = new ArrayList<>();
        List<User> integerList1 = new ArrayList<>();
        integerList.add(new User(1,"11"));
        integerList.add(new User(2,"11"));
        integerList.add(new User(4,"11"));
        integerList.add(new User(3,"11"));

        //Collections.sort(integerList,(User user1,User user2) -> {return user1.getAge().compareTo(user2.getAge());});
        Collections.sort(integerList, Comparator.comparing(User::getAge));
        integerList.forEach((User user) -> integerList1.add(0,user));
        integerList1.forEach((User user) -> System.out.println(user + "  "));
        threadWithLambdaRunnable();
    }

    private static void threadWithLambdaRunnable() {
        Runnable runnable = () -> System.out.println("这个是单条语句，不用加大括号{}");
        //静态方法用类名引用，实例方法用实例引用。
        Runnable runnable1 = Main::run;
        new Thread(runnable1).start();
        new Thread(runnable).start();
        new Thread(() -> System.out.println("这个是简化版的lambda表达式")).start();
    }

    public static void run() {
        System.out.println("这里是方法引用");
    }

    @FunctionalInterface
    private interface SelfInterface {
        int getValue(int i);
        default int getValue2(int i) {
            return 2;
        }
    }

    static class User{
        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
