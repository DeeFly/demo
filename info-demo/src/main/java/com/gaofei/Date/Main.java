package com.gaofei.Date;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by GaoQingming on 2018/1/19 0019.
 */
public class Main {
    public static void main(String[] args) throws ParseException, InvocationTargetException, IllegalAccessException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2021-04-08 00:00:00");
        System.out.println("endDate:" + parse.getTime());

        parse = simpleDateFormat.parse("2021-04-02 00:00:00");
        System.out.println("signUpEndDate:" + parse.getTime());
    }
}
