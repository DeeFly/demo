package com.gaofei.nio.writer;

import com.gaofei.nio.message.Message;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by GaoQingming on 2019/1/3 0003.
 */
public class DefaultMessageWriter implements MessageWriter {
    private Selector writeSelector;

    {
        try {
            writeSelector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(SelectionKey selectionKey) {
        try {
            SelectionKey writeSelectKey = selectionKey.channel().register(writeSelector, SelectionKey.OP_WRITE);
            writeSelectKey.attach(selectionKey.attachment());
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } finally {
            try {
                selectionKey.channel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            selectionKey.cancel();
        }

        int selected = 0;
        try {
            selected = writeSelector.selectNow();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (selected > 0) {
            Set<SelectionKey> selectionKeys =  writeSelector.selectedKeys();
            for (SelectionKey key : selectionKeys) {
                doWrite(key);
            }
        }

    }

    private void doWrite(SelectionKey key) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Message message = (Message)key.attachment();
        byteBuffer.put(message.getMessage());
        byteBuffer.flip();
        SocketChannel socketChannel = (SocketChannel)key.channel();
        while (byteBuffer.hasRemaining()) {
            try {
                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                key.cancel();
            }
        }
    }
}
