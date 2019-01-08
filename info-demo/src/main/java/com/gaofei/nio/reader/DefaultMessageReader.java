package com.gaofei.nio.reader;

import com.gaofei.nio.message.Message;
import com.gaofei.nio.processor.Processor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by GaoQingming on 2019/1/3 0003.
 */
public class DefaultMessageReader implements MessageReader {

    private Selector selector;
    private Processor processor;

    public DefaultMessageReader(Selector selector, Processor processor) {
        this.selector = selector;
        this.processor = processor;
    }

    @Override
    public void read() {
        while (true) {
            try {
                int selected = selector.selectNow();
                if (selected > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        doReadMessage(selectionKey);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doReadMessage(SelectionKey selectionKey) {
        Message message = (Message) selectionKey.attachment();
        if (message == null) {
            message = new Message();
        }
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        try {
            int reads;
            reads = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            byteBuffer.get(message.getMessage(), 0, limit);
            message.setPosition(limit);
            selectionKey.attach(message);
            //TODO 这里假设一次就读取完成所有的消息，直接交付给processor处理
            processor.process(selectionKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
