package com.gaofei.nio.reader;

import com.gaofei.nio.http.HttpHeaders;
import com.gaofei.nio.http.HttpUtil;
import com.gaofei.nio.message.Message;
import com.gaofei.nio.processor.Processor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
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
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                    while(keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();

                        doReadMessage(key);

                        //一定要remove，否则如果这个channel只读取了部分消息，即使接下来的消息到来了，selector.selectNow()也不会统计+1
                        keyIterator.remove();
                    }
                    selectedKeys.clear();
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
            int bytesRead = socketChannel.read(byteBuffer);

            while(bytesRead > 0){
                bytesRead = socketChannel.read(byteBuffer);
            }
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            byteBuffer.get(message.getMessage(), message.getPosition(), limit);
            byteBuffer.clear();
            message.setPosition(message.getPosition() + limit);
            selectionKey.attach(message);
            HttpHeaders httpHeaders = new HttpHeaders();
            int received = HttpUtil.parseHttpRequest(message.getMessage(), 0, message.getMessage().length, httpHeaders);
            if (received != -1) {
                message.setMessageStart(httpHeaders.bodyStartIndex);
                processor.process(selectionKey);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
