package com.gaofei.suanfa;

/**
 * Created by GaoQingming on 2018/1/13 0013.
 */
public class Main {
    public static void main(String[] args) {
        ByteStore byteStore = new ByteStore();
        for (int i = 0; i < 1000; i++) {
            MyItem item = new MyItem((byte)1,(byte)1,(byte)(i%127));
            byteStore.putMyItem(i,item);
        }
        byteStore.sortMyItem();
        for (int i = 0; i < 1000; i++) {
            System.out.println(byteStore.getMyItem(i));
        }
    }
}
