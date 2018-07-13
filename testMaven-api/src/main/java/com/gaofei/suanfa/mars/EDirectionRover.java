package com.gaofei.suanfa.mars;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class EDirectionRover extends DefaultRover {

    public EDirectionRover(int x, int y, int maxX, int maxY) {
        super(x,y,maxX,maxY);
        this.direction = "E";
    }

    @Override
    public void move() {
        if (x + 1 > maxX) {
            throw new MarsMissionExcepton("超出东边界的移动");
        }

        x++;
    }

    @Override
    Rover leftRover() {
        return RoverFactory.getNDirectionRover(x,y,maxX,maxY);
    }

    @Override
    Rover rightRover() {
        return RoverFactory.getSDirectionRover(x,y,maxX,maxY);
    }
}
