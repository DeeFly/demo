package com.gaofei.suanfa.mars.rovers;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public interface Rover {

    Rover switchDirection(String directive);

    void move();

    void printPostion();
}
