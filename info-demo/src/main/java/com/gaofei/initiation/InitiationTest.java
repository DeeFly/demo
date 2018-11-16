package com.gaofei.initiation;

/**
 * Created by GaoQingming on 2018/2/9 0009.
 */
public class InitiationTest {
    //这里如果想构造不可变对象。final修饰的变量不可以有默认值，不可以是static的。（因为这两种方式不可以再为变量赋值了）
    private final String name;

    public InitiationTest(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        System.out.println(new InitiationTest("haha").getName());
    }

    public String getName() {
        return name;
    }
}
