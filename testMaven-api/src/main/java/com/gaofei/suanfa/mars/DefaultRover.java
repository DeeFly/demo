package com.gaofei.suanfa.mars;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public abstract class DefaultRover implements Rover{
    protected int x;
    protected int y;
    protected int maxX;
    protected int maxY;
    protected String direction;

    public DefaultRover(int x, int y, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Rover switchDirection(String directive) {
        if (LEFT.equals(directive)) {
            return leftRover();
        } else if (RIGHT.equals(directive)) {
            return rightRover();
        } else {
            throw new RuntimeException("您的指令有误:" + directive);
        }
    }

    @Override
    public void printPostion() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x)
                .append(" ")
                .append(y)
                .append(" ")
                .append(direction);
        System.out.println(stringBuilder.toString());
    }

    abstract Rover leftRover();

    abstract Rover rightRover();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
