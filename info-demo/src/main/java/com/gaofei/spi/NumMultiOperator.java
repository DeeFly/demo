package com.gaofei.spi;

/**
 * @author yichang
 * @date 2020/06/18
 */
public class NumMultiOperator implements INumOperator {
    @Override
    public int operate(int a, int b) {
        System.out.println("multi operate");
        return a * b;
    }
}
