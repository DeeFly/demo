package com.gaofei.classLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/1/31 0031.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("haha");
    }
}

class Page<T,A> {
    private T wrapper;
    private A wrapperA;

    public static <B> void variableLengthArgs(B ...args) {
        if (args == null) return ;
        List<B> list = new ArrayList<B>();
        for (B arg : args) {
            list.add(arg);
        }
        B[] array = (B[]) Array.newInstance(args[0].getClass(),10);
    }

    public A getWrapperA() {
        return wrapperA;
    }

    public void setWrapperA(A wrapperA) {
        this.wrapperA = wrapperA;
    }

    private int page;

    public T getWrapper() {
        return wrapper;
    }

    public void setWrapper(T wrapper) {
        this.wrapper = wrapper;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}