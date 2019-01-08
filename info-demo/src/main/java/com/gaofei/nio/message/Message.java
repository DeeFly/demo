package com.gaofei.nio.message;

/**
 * 从socket读取的消息，可能不全，
 * Created by GaoQingming on 2019/1/3 0003.
 */
public class Message {
    private byte[] message = new byte[1024];
    //下一个可写的位置
    private int position = 0;

    private int messageStart = 0;

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMessageStart() {
        return messageStart;
    }

    public void setMessageStart(int messageStart) {
        this.messageStart = messageStart;
    }
}
