package com.gaofei.file;

import java.io.InputStream;

/**
 * Created by GaoQingming on 2018/1/13 0013.
 */
public class LoaderResource {
    public InputStream getInputStream (String path) {
        return this.getClass().getClassLoader().getResourceAsStream("test.txt");
    }
}
