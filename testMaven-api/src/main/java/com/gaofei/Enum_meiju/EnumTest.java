package com.gaofei.Enum_meiju;

/**
 * Created by GaoQingming on 2018/2/2 0002.
 */
public enum  EnumTest {
    ONE("one") {
        @Override
        void reset() {
            System.out.println("one");
        }
    },TWO("two") {
        @Override
        void reset() {
            System.out.println("two");
        }
    };
    private String name;

    abstract void reset();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    EnumTest (String name) {
        this.name = name;
    }
}
