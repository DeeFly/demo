package com.gaofei.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GaoQingming on 2018/12/21 0021.
 */
public class FileChannelTest {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\temp\\test.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        try {
            int readCount = fileChannel.read(byteBuffer);
            while (readCount != -1) {
                //flip切换到读模式
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    char c = (char)byteBuffer.get();
                    System.out.print(c);
                }

                //clear切换到写模式
                byteBuffer.clear();
                readCount = fileChannel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
