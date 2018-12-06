package com.gaofei.jicheng;

/**
 * 抽象类Parent没有实现此接口，但是Parent中实现了getString方法
 * 实体类Child继承了抽象类Parent
 * 实体类Child实现了此接口，但是Child中并没有重写getString方法。
 *
 * 此时没有问题，可以理解为抽象类中实现了接口中的方法。
 * Created by GaoQingming on 2018/12/4 0004.
 */
public interface MyInterface {
    String wangwei();
}
