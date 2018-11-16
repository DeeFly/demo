package com.gaofei.Enum_meiju;

/**
 * Created by GaoQingming on 2018/2/2 0002.
 */
public enum  EnumTest {
    ONE("one") {
        @Override
        public void reset() {
            System.out.println("one");
        }
    },TWO("two") {
        @Override
        public void reset() {
            System.out.println("two");
        }
    };
    private String name;

    public abstract void reset();

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
