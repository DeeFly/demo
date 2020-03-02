package com.gaofei.numberFormat;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yichang on 2019/5/10
 */
public class FormatTest {
    private static final Pattern YUAN_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
    public static void main(String[] args) {
        String s = "23.3424534534";
        BigDecimal bg = new BigDecimal(s);
        System.out.println(bg.toString());
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }


    public static Integer parseInt(String value){
        if(value==null){
            return null;
        }
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException n){
            return null;
        }
    }

    public static Long objToLong(Object value){
        if(value==null){
            return null;
        }
        try{
            return Long.parseLong(value.toString());
        }catch (Exception n){
            return null;
        }
    }

    public static Integer objToInt(Object value){
        if(value==null){
            return null;
        }
        try{
            return Integer.parseInt(value.toString());
        }catch (Exception n){
            return null;
        }
    }

    public static Long strToLong(String value){
        if(value==null){
            return null;
        }
        try{
            return Long.parseLong(value);
        }catch (Exception n){
            return null;
        }
    }

    public static String formatLong(Long data) {
        if(data == null) {
            return "-";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(data);
    }

    public static String formatDouble(BigDecimal data) {
        if (data == null) {
            return "-";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(data);
    }

    public static long parse(Long number) {
        return number == null ? 0L : number;
    }

    public static int parse(Integer number) {
        return number == null ? 0 : number;
    }

    public static boolean isLongNumber(String str) {

        if (StringUtils.isEmpty(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isYuanFormat(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Matcher isNum = YUAN_PATTERN.matcher(str);
        return isNum.matches();
    }
}
