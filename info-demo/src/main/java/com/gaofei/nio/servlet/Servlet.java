package com.gaofei.nio.servlet;

import com.gaofei.nio.message.Message;

/**
 * Created by GaoQingming on 2019/1/13.
 */
public interface Servlet {
    void doGet(Message message);

    void doGet(String request);
}
