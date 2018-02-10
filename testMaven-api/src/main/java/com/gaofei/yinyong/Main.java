package com.gaofei.yinyong;

/**
 * Created by GaoQingming on 2018/1/4 0004.
 */
public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.setName("111");
        aaa(test);
        System.out.println(test.getName());
    }

    private static void aaa(Test test) {
        Test test1 = new Test();
        test1.setName("2222222");
        test.setName("33333333");
    }
}
class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
