package com.gaofei.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by GaoQingming on 2018/1/13 0013.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        InputStream inputStream = new LoaderResource().getInputStream("test.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while (bufferedReader.readLine() != null) {
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
