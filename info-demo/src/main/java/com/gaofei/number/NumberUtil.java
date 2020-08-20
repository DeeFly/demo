package com.gaofei.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author yichang
 * @date 2020/08/19
 */
public class NumberUtil {
    private static final String DEFAULT_SEPARATOR = ",";

    public static Long parse(Long num) {
        return parse(num, 0);
    }

    public static Long parse(Long num, long defaultVal) {
        if (num == null) {
            return defaultVal;
        }
        return num;
    }

    public static Integer parseInteger(String string) {
        return parseInteger(string, 0);
    }

    public static Integer parseInteger(String string, Integer defaultVal) {
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {

        }
        return defaultVal;
    }

    public static Long parseLong(String string) {
        return parseLong(string, 0L);
    }

    public static Long parseLong(String string, Long defaultVal) {
        try {
            return Long.valueOf(string);
        } catch (NumberFormatException e) {

        }
        return defaultVal;
    }

    public static boolean platformNumberEquals(String value1, String value2) {
        try {
            BigDecimal bigDecimal1 = new BigDecimal(value1).setScale(3, RoundingMode.HALF_UP);
            BigDecimal bigDecimal2 = new BigDecimal(value2).setScale(3, RoundingMode.HALF_UP);
            return bigDecimal1.compareTo(bigDecimal2) == 0;
        } catch (Exception e) {
            //log.error("对比数字相等出错.value1:{},value2:{},e:{}", value1, value2, e);
        }
        return false;
    }

    public static <T> List<T> toList(String string, Function<String, T> mapper) {
        return toList(string, mapper, DEFAULT_SEPARATOR);
    }

    public static <T> List<T> toList(String string, Function<String, T> mapper, String split) {
        if (string == null || string.isEmpty()) {
            return Lists.newArrayList();
        }
        return Splitter.on(split == null ? DEFAULT_SEPARATOR : split)
            .omitEmptyStrings()
            .splitToList(string)
            .stream()
            .map(mapper)
            .collect(Collectors.toList());
    }

    private static final Pattern YUAN_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");

    private static final Pattern INTEGER_OR_SIX_DECIMAL_MAX = Pattern.compile("[0-9]+(\\.[0-9]{1,6})?");

    public static Integer parseInt(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException n) {
            return null;
        }
    }

    public static Long objToLong(Object value) {
        if (value == null) {
            return null;
        }
        try {
            return Long.parseLong(value.toString());
        } catch (Exception n) {
            return null;
        }
    }

    public static Integer objToInt(Object value) {
        if (value == null) {
            return null;
        }
        try {
            return Integer.parseInt(value.toString());
        } catch (Exception n) {
            return null;
        }
    }

    public static Long strToLong(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Long.parseLong(value);
        } catch (Exception n) {
            return null;
        }
    }

    public static String formatLong(Long data) {
        if (data == null) {
            return "-";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(data);
    }

    public static Double trimDouble(Object data) {
        return trimDouble(data, 2);
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

    public static String formatDouble(BigDecimal data) {
        if (data == null) {
            return "-";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(data);
    }

    /**
     * 千分位 and 保留几位小数
     * @param data BigDecimal/Double/Long
     * @param maxFractionDigits
     * @return
     */
    public static String formatObject(Object data, int maxFractionDigits){
        if (data == null) {
            return "-";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(maxFractionDigits);
        return nf.format(data);
    }

    public static String formatDouble(Double data) {
        return formatDouble(data, 2);
    }

    public static String formatDoubleToPercent(Double data) {
        if (data == null) {
            return "";
        }
        return formatDouble(data * 100, 2) + "%";
    }

    public static String formatDouble(Double data, int maxFractionDigits) {
        if (data == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(maxFractionDigits);
        return nf.format(data);
    }

    public static int parse(Integer number) {
        return number == null ? 0 : number;
    }

    public static boolean isLongNumber(String str) {

        if (Strings.isNullOrEmpty(str)) {
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

    public static boolean isIntegerOrSixDecimalMax(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Matcher isNum = INTEGER_OR_SIX_DECIMAL_MAX.matcher(str);
        return isNum.matches();
    }

    public static boolean isIntegerOrDecimalDigitMax(String str, int digit) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String regix = "[0-9]+(\\.[0-9]{1," + digit + "})?";
        Pattern integerOrDecimalDigitMax = Pattern.compile(regix);
        Matcher isNum = integerOrDecimalDigitMax.matcher(str);
        return isNum.matches();
    }

    /**
     * 判断是否是数字（包括小数，整数，正负数，e）
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        String str = s.trim();
        //是否出现了点
        boolean point = false;
        //是否出现了e
        boolean e = false;
        //是否出现了数字
        boolean number = false;
        //e之后是否出现数字
        boolean numberAfterE = true;
        for (int i = 0; i < str.length(); i++) {
            //出现了数字
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number = true;
                numberAfterE = true;
            } else if (str.charAt(i) == '.') {
                //出现了点，出现了e和点之后不能再出现点
                if (point || e) {
                    return false;
                }
                point = true;
            } else if (str.charAt(i) == 'e') {
                //出现了e，出现过e之后不能再出现,且前面必须要有数字
                if (e || !number) {
                    return false;
                }
                e = true;
                numberAfterE = false;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                //出现正负号 要么在第一位，要么在e的后面
                if (i != 0 && str.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return number && numberAfterE;
    }

    private static boolean isMatch(String regex, String orginal){
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }

    public static boolean isPositiveInteger(String orginal) {
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal);
    }

    public static boolean isNegativeInteger(String orginal) {
        return isMatch("^-[1-9]\\d*", orginal);
    }

    public static boolean isWholeNumber(String orginal) {
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);
    }

    public static boolean isPositiveDecimal(String orginal){
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);
    }

    public static boolean isNegativeDecimal(String orginal){
        return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);
    }

    public static boolean isDecimal(String orginal){
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
    }

    public static boolean isRealNumber(String orginal){
        return isWholeNumber(orginal) || isDecimal(orginal);
    }

}
