package com.gaofei.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author qingming.gqm
 * @date 2020/1/4
 */
public class Patterns {
    /**
     * 数字、字母、中文
     */
    private static final  Pattern AMOUNT_LETTER_CHINESE = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z-z0-9]+$");
    /**
     *
     */
    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^([-,+]?[0-9]+)(\\.[0-9][0-9]?)?$");


    public static void main(String[] args) {
        System.out.println(isLongNumber("ALL"));
    }

    /**
     * 最多两位小数，可以没有小数
     * @param moneyStr
     * @return
     */
    public static boolean checkPriceTwoDecimal(String moneyStr){
        if(StringUtils.isEmpty(moneyStr)){
            return false;
        }
        String reg = "^(?!0(\\d|\\.0+$|$))\\d+(\\.\\d{1,2})?$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(moneyStr);
        return matcher.matches();
    }

    /**
     * 是否是合法的金额，单位元
     *
     * @param moneyStr
     * @return
     */
    public static boolean isLegalMoneyNum(String moneyStr){
        return AMOUNT_PATTERN.matcher(moneyStr).matches();
    }

    public static boolean isLegalName(String name) {
        return AMOUNT_LETTER_CHINESE.matcher(name).matches();
    }

    public static boolean isLongNumber(String str) {

        if (StringUtils.isBlank(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
