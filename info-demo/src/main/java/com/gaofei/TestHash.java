package com.gaofei;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 同一个类new出来两个对象，属性值相同，hash值也不相同（如果不重写hashCode的方法的话)
 * 这么new 一个BigDecimal是有问题的。
 * BigDecimal b = new BigDecimal(0.1D);
 * Created by GaoQingming on 2017/12/8 0008.
 */
public class TestHash {
    public static final String DATE_PATTERN_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    static class InnerClass {
        private String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        @Override
        public int hashCode() {
            return 1;
        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.forEach((key, value) -> {});
        ArrayList list = new ArrayList();
        list.size();
        list.isEmpty();
        String s = "1,2,3,,,,,,";
        String[] split = s.split(",");
        System.out.println(split.length);
    }
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }

    public static Date parseDate(String dateStr, String formatPattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(formatPattern);
            return DateTime.parse(dateStr, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }
}
