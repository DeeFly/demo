package com.gaofei.nio.processor;

import com.gaofei.nio.message.Message;
import com.gaofei.nio.writer.MessageWriter;

import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;

/**
 * Created by GaoQingming on 2019/1/3 0003.
 */
public class DefaultProcessor implements Processor {
    private MessageWriter messageWriter;

    public DefaultProcessor(MessageWriter messageWriter) {
        this.messageWriter = messageWriter;
    }

    @Override
    public void process(SelectionKey selectionKey) {
        Message message = (Message)selectionKey.attachment();
        System.out.println(new String(message.getMessage(), 0, message.getPosition()));

        String response = "we received your message...";
        byte[] responseBytes = response.getBytes(Charset.forName("UTF-8"));
        message.setMessage(responseBytes);
        messageWriter.write(selectionKey);
    }
}