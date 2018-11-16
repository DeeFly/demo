package com.gaofei.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class ChannelTest {

    public void channelTest() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\testFile\\test.txt","rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int length = fileChannel.read(byteBuffer);

            while (length != -1) {
                System.out.println("本次读取长度为：" + length);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println("本次读取的内容为:" + (char)byteBuffer.get());
                }

                byteBuffer.clear();
                length = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
