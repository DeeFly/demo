package com.gaofei;

import java.util.HashSet;

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
        InnerClass innerClass = new InnerClass();
        InnerClass innerClass1 = new InnerClass();
        HashSet<InnerClass> hashSet = new HashSet<InnerClass>();
        hashSet.add(innerClass);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hashSet.add(innerClass);
        System.out.println(hashSet.size());
        //System.out.println("inner hashcode:" + innerClass.hashCode());
        //System.out.println("inner 1 hashCode:" + innerClass1.hashCode());
        //System.out.println("Object hashCode:" + ((Object)innerClass).hashCode());
        //System.out.println("Object 1 hashCode:" + ((Object)innerClass1).hashCode());
    }
}
