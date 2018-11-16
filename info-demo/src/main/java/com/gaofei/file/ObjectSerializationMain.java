package com.gaofei.file;

import java.io.*;

/**
 * Created by GaoQingming on 2018/1/3 0003.
 */
public class ObjectSerializationMain {
    public static void main(String[] args) {
        MySerialization mySerialization1 = new MySerialization();
        mySerialization1.setAge(4);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt"));
            objectOutputStream.writeObject(mySerialization1);
            objectOutputStream.writeObject(mySerialization1);
            mySerialization1.setAge(190);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
            MySerialization mySerialization2 = (MySerialization)objectInputStream.readObject();
            System.out.println(mySerialization1 == mySerialization2);

            MySerialization mySerialization3 = (MySerialization)objectInputStream.readObject();
            System.out.println(mySerialization2 == mySerialization3);
            System.out.println("my2:" + mySerialization2.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static class MySerialization implements Serializable {
        private static int age = 1;
        private String name;

        public String getName() {
            return name;
        }

        public static int getAge() {
            return age;
        }

        public static void setAge(int age) {
            MySerialization.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        protected Object readResolve() {
            //反序列化2和3但是这里只执行了一次，说明在遇到相同的对象时，直接返回以前序列化好的，不再重新实例化，所以2和三 == true
            System.out.println("readResolve come!");
            return this;
        }
    }
}
