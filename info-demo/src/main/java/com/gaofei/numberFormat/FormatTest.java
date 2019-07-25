package com.gaofei.numberFormat;

import java.math.BigDecimal;

/**
 * Created by yichang on 2019/5/10
 */
public class FormatTest {
    public static void main(String[] args) {
        String s = "23.3424534534";
        BigDecimal bg = new BigDecimal(s);
        System.out.println(bg.toString());
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
}
