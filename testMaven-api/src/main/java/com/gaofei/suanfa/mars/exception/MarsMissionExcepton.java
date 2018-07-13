package com.gaofei.suanfa.mars.exception;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class MarsMissionExcepton extends RuntimeException {

    private String message;

    public MarsMissionExcepton(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
