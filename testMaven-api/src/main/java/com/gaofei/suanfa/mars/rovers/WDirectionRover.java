package com.gaofei.suanfa.mars.rovers;

import com.gaofei.suanfa.mars.constants.Directions;
import com.gaofei.suanfa.mars.exception.MarsMissionExcepton;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class WDirectionRover extends DefaultRover {

    public WDirectionRover(int x, int y, int maxX, int maxY) {
        super(x,y,maxX,maxY);
        this.direction = Directions.WEST;
    }

    @Override
    public void move() {
        if (x - 1 < 0) {
            throw new MarsMissionExcepton("超出西边界的移动");
        }

        x--;
    }

    @Override
    Rover leftRover() {
        return RoverFactory.getSDirectionRover(x,y,maxX,maxY);
    }

    @Override
    Rover rightRover() {
        return RoverFactory.getNDirectionRover(x,y,maxX,maxY);
    }
}
