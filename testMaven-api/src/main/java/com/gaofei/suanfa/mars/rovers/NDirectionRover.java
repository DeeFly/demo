package com.gaofei.suanfa.mars.rovers;

import com.gaofei.suanfa.mars.constants.Directions;
import com.gaofei.suanfa.mars.exception.MarsMissionExcepton;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class NDirectionRover extends DefaultRover {

    public NDirectionRover(int x, int y, int maxX, int maxY) {
        super(x,y,maxX,maxY);
        this.direction = Directions.NORTH;
    }

    @Override
    public void move() {
        if (y + 1 > maxY) {
            throw new MarsMissionExcepton("超出北边界的移动");
        }

        y++;
    }

    @Override
    Rover leftRover() {
        return RoverFactory.getWDirectionRover(x,y,maxX,maxY);
    }

    @Override
    Rover rightRover() {
        return RoverFactory.getEDirectionRover(x,y,maxX,maxY);
    }
}
