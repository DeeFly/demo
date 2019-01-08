package com.gaofei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class SocketChannelTest {
    public static void main(String[] args) {
        new SocketChannelTest().socketChannelTest();
    }
    public void socketChannelTest() {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            byteBuffer.clear();
            String step1 = "GET / HTTP/1.1\r\n" +
                    "Content-Length: 5\r\n";
            byteBuffer.put(step1.getBytes());

            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }

            //模拟网络消息请求延迟10秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String step2 = "\r\n12345";
            byteBuffer.clear();
            byteBuffer.put(step2.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }

            byteBuffer.clear();
            int length = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            byte[] response = new byte[length];
            byteBuffer.get(response, 0, length);
            String responseString = new String(response);
            System.out.println("本次读取的长度为:" + length);
            System.out.println("本次读取的内容为:" + responseString);
            //while (length != -1) {
            //    System.out.println("本次读取的长度为:" + length);
            //    while (byteBuffer.hasRemaining()) {
            //        System.out.println("本次读取的内容为:" + (char)byteBuffer.get());
            //    }
            //    byteBuffer.clear();
            //    length = socketChannel.read(byteBuffer);
            //}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketChannel != null) {
                try {
                    //这里如果没有显示关闭，服务器那边会报错 java.io.IOException: 远程主机强迫关闭了一个现有的连接。
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
