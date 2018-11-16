package com.gaofei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class ServerSocketChannelTest {
    public static void main(String[] args) {
        new ServerSocketChannelTest().serverSocketChannelTest();
    }
    public void serverSocketChannelTest() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            //serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                handleSocketChannel(socketChannel);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleSocketChannel(SocketChannel socketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        try {
            int length = socketChannel.read(byteBuffer);
            while (length != -1) {
                System.out.println("本次读取的长度为：" + length);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println("本次读取的内容为:" + (char)byteBuffer.get());
                }
                byteBuffer.clear();
                length = socketChannel.read(byteBuffer);
            }
            byteBuffer.clear();
            byteBuffer.put("server response".getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
