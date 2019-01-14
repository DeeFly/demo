package com.gaofei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");
        stringList.forEach((value) -> {});

        Stream<String> stream = stringList.stream();

        Stream<String> streamPeeked = stream.peek((value) -> {
            System.out.println("value");
        });
    }
}
