package com.gaofei.fanxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/2/2 0002.
 */
//泛型类
class Page<T,A> {
    private T wrapper;
    private A wrapperA;

    //泛型方法，泛型变长参数
    public static <B> void variableLengthArgs(B ...args) {
        if (args == null) return ;
        //泛型列表
        List<B> list = new ArrayList<B>();
        for (B arg : args) {
            list.add(arg);
        }
        //数组
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
