package com.gaofei.nio.processor;

import com.gaofei.nio.classLoader.MyClassLoader;
import com.gaofei.nio.message.Message;
import com.gaofei.nio.servlet.Servlet;
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
        String request = new String(message.getMessage(), message.getMessageStart(), message.getPosition() - message.getMessageStart());
        System.out.println("request:" + request);
        findMappingServlet(request).doGet(request);
        String response = "we received your message:" + request;
        byte[] responseBytes = response.getBytes(Charset.forName("UTF-8"));
        message.setMessage(responseBytes);
        messageWriter.write(selectionKey);
    }

    private Servlet findMappingServlet(String request){
        ClassLoader classLoader = new MyClassLoader();
        Servlet mappingServlet = null;
        String path = "E:\\temp\\MyServlet.class";
        try {
            mappingServlet = (Servlet)(classLoader.loadClass(path).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mappingServlet;
    }
}
