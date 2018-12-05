package com.gaofei.jicheng;

/**
 * Created by GaoQingming on 2018/1/24 0024.
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.a();
        Parent child2 = new Child();
        child2.a();
        Parent child3 = new Parent();
        child3.a();
        System.out.println(child.wangwei());
        /**
         * 输出如下：
         * 这个地方厉害了，一定要看看，模板方法新理解！！
         parent a
         child b
         parent a
         child b
         parent a
         parent b
         */
    }
}
