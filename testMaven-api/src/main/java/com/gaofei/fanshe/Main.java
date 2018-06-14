package com.gaofei.fanshe;

import java.lang.reflect.Method;

/**
 * getDeclaredMethod 这个不能获取父类中的方法。
 * Created by GaoQingming on 2018/1/16 0016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            final Method getIdMethod = Person.class.getDeclaredMethod("getUserId");
            System.out.println("sdfs");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

class User {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

 class Person{
    private String name;
    private String id;
     private String userId;

     public String getUserId() {
         return userId;
     }

     public void setUserId(String userId) {
         this.userId = userId;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
