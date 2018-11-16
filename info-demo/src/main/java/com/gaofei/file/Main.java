package com.gaofei.file;

import java.io.*;

/**
 * Created by GaoQingming on 2018/1/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            fileInputStream.getChannel();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String s = bufferedReader.readLine();
            System.out.println(s);
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File("test.txt")),false);
            printWriter.println("test !" + System.currentTimeMillis());
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
