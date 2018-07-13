package com.gaofei.suanfa.mars.rovers;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class RoverFactory {

    public static Rover getEDirectionRover(int x, int y, int maxX, int maxY) {
        return new EDirectionRover(x,y,maxX,maxY);
    }

    public static Rover getWDirectionRover(int x, int y, int maxX, int maxY) {
        return new WDirectionRover(x,y,maxX,maxY);
    }

    public static Rover getSDirectionRover(int x, int y, int maxX, int maxY) {
        return new SDirectionRover(x,y,maxX,maxY);
    }

    public static Rover getNDirectionRover(int x, int y, int maxX, int maxY) {
        return new NDirectionRover(x,y,maxX,maxY);
    }
}
