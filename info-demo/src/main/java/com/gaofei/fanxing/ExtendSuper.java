package com.gaofei.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/10/3.
 */
public class ExtendSuper {
    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Apple1 extends Apple {
    }

    static class Orange extends Fruit {
    }


    public static void main(String[] args) {
        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Apple1());
        //list.add(new Fruit());

        Object apple = list.get(0);


        //extend
        List<? extends Fruit> list2 = new ArrayList<>();
        //list2.add(new Apple());
        //list2.add(new Orange());
        //list2.add(new Fruit());
        list2.add(null);

        list2.contains(new Apple());
        list2.indexOf(new Apple());

        Fruit apple2 = list2.get(0);

    }
}
