package com.gaofei.nio.classLoader;

/**
 * Created by GaoQingming on 2019/1/13.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
