package com.gaofei.nio.webapps;

import com.gaofei.nio.message.Message;
import com.gaofei.nio.servlet.Servlet;

/**
 * Created by GaoQingming on 2019/1/13.
 */
public class MyServlet implements Servlet {
    @Override
    public void doGet(Message message) {
        java.lang.String request = new String(message.getMessage(), message.getMessageStart(), message.getPosition() - message.getMessageStart());

        System.out.println("my servlet handler request:" + request);
    }

    @Override
    public void doGet(String request) {
        System.out.println("my servlet handler request:" + request);
    }
}
