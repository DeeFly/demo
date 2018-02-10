package com.gaofei.Date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoQingming on 2018/1/19 0019.
 */
public class Main {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,3);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DAY_OF_YEAR,1);
        }
        System.out.println(c.getTime().getTime() - new Date().getTime());

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString());

        String s2 = "sdf" + null;
        System.out.println(s2);
    }
}
