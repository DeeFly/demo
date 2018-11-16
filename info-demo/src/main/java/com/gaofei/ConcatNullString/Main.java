package com.gaofei.ConcatNullString;

import java.util.Optional;

/**
 * Created by GaoQingming on 2018/1/4 0004.
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("sdggasdg".replace("sdfsd",null));
        //String[] strings = {"1","2","3"};
        //List<String> list = Arrays.asList(strings);
        //list.forEach(System.out::println);
        Optional.ofNullable("").orElseThrow(()-> new RuntimeException("sdfsdfgsdg"));
    }
}
