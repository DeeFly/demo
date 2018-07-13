package com.gaofei.suanfa.mars.rovers;

import com.gaofei.suanfa.mars.constants.Directions;
import com.gaofei.suanfa.mars.exception.MarsMissionExcepton;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class SDirectionRover extends DefaultRover {

    public SDirectionRover(int x, int y, int maxX, int maxY) {
        super(x,y,maxX,maxY);
        this.direction = Directions.SOUTH;
    }

    @Override
    public void move() {
        if (y - 1 < 0) {
            throw new MarsMissionExcepton("超出南边界的移动");
        }

        y--;
    }

    @Override
    Rover leftRover() {
        return RoverFactory.getEDirectionRover(x,y,maxX,maxY);
    }

    @Override
    Rover rightRover() {
        return RoverFactory.getWDirectionRover(x,y,maxX,maxY);
    }
}
