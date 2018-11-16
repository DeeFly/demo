package com.gaofei.collection;

import java.util.*;

/**
 * 踩过这个坑，AbstractList的add方法如果没有被重写的话，默认抛出java.lang.UnsupportedOperationException
 * Created by GaoQingming on 2018/5/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        //List list = Collections.emptyList();
        //list.add(new Object());
        Set<String> set = new HashSet<>();
        set.add("1");
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
        unmodifiableSet.add("2");
        System.out.println(unmodifiableSet.size());

        List<User> list1 = new ArrayList<>();
        list1.add(new User("gaofei"));
        list1.add(new User("222"));
        //list2不能做增删操作，但是对list1的增删操作会传递到list2
        List<User> list2 = Collections.unmodifiableList(list1);
        list1.add(new User("333"));
        list1.remove(1);
        //list2.add(new User("333"));
        System.out.println();
        list1.forEach(System.out::println);
        System.out.println();
        list2.forEach(System.out::println);
    }


}
class User {

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
