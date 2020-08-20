package com.gaofei.Date;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by GaoQingming on 2018/1/19 0019.
 */
public class Main {
    public static void main(String[] args) throws ParseException, InvocationTargetException, IllegalAccessException {
        String itemIdListString = "569254438632,559777325437";
        List<String> itemIdStringList = Arrays.asList(itemIdListString.split(" |,|\n")).stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        String[] split = itemIdListString.split(" |,|\n");
        List<String> strings = Arrays.asList(split);

        itemIdStringList.forEach(itemId -> {
            if (!isLongNumber(itemId)) {
                System.out.println(itemId);
            }
        });
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
}
