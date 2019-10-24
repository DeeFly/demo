package com.gaofei.string;

/**
 * @author qingming.gqm
 * @date 2019/10/23
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());
        stringBuffer.append("test");
        System.out.println(stringBuffer.length());
    }
}
