package com.gaofei.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    private static final Pattern YUAN_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
    public static void main(String[] args) {
        System.out.println(new Double(0.000).equals(new Double(0)));
        System.out.println(isYuanFormat("0.12"));
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
}
