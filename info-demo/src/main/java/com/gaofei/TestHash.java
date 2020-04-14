package com.gaofei;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSON;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 同一个类new出来两个对象，属性值相同，hash值也不相同（如果不重写hashCode的方法的话)
 * Created by GaoQingming on 2017/12/8 0008.
 */
public class TestHash {
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
        System.out.println(new Date(1583769600000L).toGMTString());
        List<Integer> integers = IntStream.range(0, 105).boxed().collect(Collectors.toList());
        System.out.println(integers.size());
        int startPos = 0;
        int endPos = 10;
        do {
            List<Integer> integers1 = integers.subList(startPos, Math.min(endPos, integers.size()));
            startPos += 10;
            endPos += 10;
            System.out.println(JSON.toJSONString(integers1));
        } while (endPos - 10 < integers.size() );
    }
}
