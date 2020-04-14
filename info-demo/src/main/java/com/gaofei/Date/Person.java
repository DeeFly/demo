package com.gaofei.Date;

import java.util.HashMap;

/**
 * @author qingming.gqm
 * @date 2020/4/2
 */
public class Person extends HashMap<String, Object> {
    private String name;
    private Double age;

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
