package com.gaofei.factory;

import java.util.List;

/**
 * @author qingming.gqm
 * @date 2020/4/14
 */
public interface Supporter {
    /**
     * 表明支持的类型
     * @return
     */
    List<Integer> support();
}