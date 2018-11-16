package com.gaofei.duotai;

/**
 * Created by GaoQingming on 2017/12/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        Parent child = new Child();

        child.printFinal();
        child.printStatic();
    }
}
