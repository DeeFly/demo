package com.gaofei.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by GaoQingming on 2018/2/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"234", null, "345", null};
        List<String> strings = Arrays.stream(stringArray).collect(Collectors.toList());
        System.out.println(strings.size());
        strings.add(null);
        strings.add(null);
        System.out.println(strings.size());
    }


}
