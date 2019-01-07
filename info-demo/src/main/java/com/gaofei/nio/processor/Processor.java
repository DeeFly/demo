package com.gaofei.nio.processor;

import java.nio.channels.SelectionKey;

/**
 * Created by GaoQingming on 2019/1/3 0003.
 */
public interface Processor {
    /**
     * 处理已经读取完数据的socket
     * 执行业务逻辑
     * @param selectionKey
     */
    void process(SelectionKey selectionKey);
}
