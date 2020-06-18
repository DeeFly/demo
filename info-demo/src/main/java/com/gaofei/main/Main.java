package com.gaofei.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    private static final Pattern YUAN_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
    public static void main(String[] args) {
        System.out.println(trimDouble(196.399999, 2));
    }

    static class Persion {
        private Double age;

        public Persion(Double age) {
            this.age = age;
        }

        public Double getAge() {
            return age;
        }

        public void setAge(Double age) {
            this.age = age;
        }
    }

    public static boolean isYuanFormat(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Matcher isNum = YUAN_PATTERN.matcher(str);
        return isNum.matches();
    }

    public static Double trimDouble(Object data, int scale) {
        if (data == null) {
            return null;
        }
        if (data instanceof Double) {
            return new BigDecimal((Double)data).setScale(scale, RoundingMode.HALF_UP).doubleValue();
        } else if (data instanceof BigDecimal) {
            return ((BigDecimal)data).setScale(scale, RoundingMode.HALF_UP).doubleValue();
        } else if (data instanceof Long) {
            return new Double((Long)data);
        } else if (data instanceof String) {
            return new BigDecimal((String)data).setScale(scale, RoundingMode.HALF_UP).doubleValue();
        }
        throw new NumberFormatException("未知的数据类型:" + data.getClass().getName());
    }
}
