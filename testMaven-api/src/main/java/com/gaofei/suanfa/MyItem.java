package com.gaofei.suanfa;

/**
 * Created by GaoQingming on 2018/1/13 0013.
 */
public class MyItem {
    private byte type;
    private byte color;
    private byte price;

    public MyItem(byte type, byte color, byte price) {
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public byte getPrice() {
        return price;
    }

    public void setPrice(byte price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return price + "";
    }
}
