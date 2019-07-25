package com.gaofei.lambdaTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 测试是否线程安全
 * @author qingming.gqm
 * @date 2019/6/6
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 10000).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10; i++) {
            List<String> strings = integers.parallelStream().map(n -> n + "yes").collect(Collectors.toList());
            System.out.println(strings.size());
        }

    }
}
