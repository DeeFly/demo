package com.gaofei.nio.classLoader;

import java.io.*;

/**
 * Created by GaoQingming on 2019/1/13.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classByte = findClassData(name);
        return super.defineClass(null, classByte, 0, classByte.length);
    }

    private byte[] findClassData(String name) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream in = null;
        try {
            in = new FileInputStream(new File(name));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            while ((i = in.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }
}
