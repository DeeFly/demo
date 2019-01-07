package com.gaofei.nio.writer;

import java.nio.channels.SelectionKey;

/**
 * Created by GaoQingming on 2019/1/3 0003.
 */
public interface MessageWriter {
    void write(SelectionKey selectionKey);
}
