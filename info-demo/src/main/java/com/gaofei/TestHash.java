package com.gaofei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        String empty = null;
        System.out.println(new String(empty));
    }
}
