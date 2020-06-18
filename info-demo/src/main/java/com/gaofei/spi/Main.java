package com.gaofei.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 需要在META-INF下创建接口同名文件，里面放实现类的全限定名，可以有多个
 * @author yichang
 * @date 2020/06/18
 */
public class Main {
    public static void main(String[] args) {
        INumOperator operator = new NumAddOperator();
        operator.operate(1, 2);

        ServiceLoader<INumOperator> serviceLoader = ServiceLoader.load(INumOperator.class);
        Iterator<INumOperator> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            iterator.next().operate(1,2);
        }
    }
}
