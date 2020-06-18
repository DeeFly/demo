package com.gaofei.spi;

/**
 * @author yichang
 * @date 2020/06/18
 */
public class NumAddOperator implements INumOperator {
    @Override
    public int operate(int a, int b) {
        System.out.println("add operate");
        return a + b;
    }
}
