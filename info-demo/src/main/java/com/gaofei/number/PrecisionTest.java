package com.gaofei.number;

import java.math.BigDecimal;

/**
 * @author yichang
 * @date 2020/06/02
 */
public class PrecisionTest {
    public static void main(String[] args) {
        double d = 0.3D;
        System.out.println(d);
        System.out.println(d - 0.1D);
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);
    }
}
