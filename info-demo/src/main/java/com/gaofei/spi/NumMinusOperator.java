package com.gaofei.spi;

/**
 * @author yichang
 * @date 2020/06/18
 */
public class NumMinusOperator implements INumOperator {
    @Override
    public int operate(int a, int b) {
        System.out.println("minus operate");
        return a - b;
    }
}
