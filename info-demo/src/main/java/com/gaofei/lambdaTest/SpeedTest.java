package com.gaofei.lambdaTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author qingming.gqm
 * @date 2019/9/18
 */
public class SpeedTest {
    public static void main(String[] args) {
        List<Long> longs = LongStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());





        long begin = System.currentTimeMillis();
        for (int i = 0; i < longs.size(); i++) {
            compute(longs.get(i));
        }
        long duration = System.currentTimeMillis() - begin;
        System.out.println("normal for int i past " + duration);




        begin = System.currentTimeMillis();
        longs.forEach(i -> {
            compute(i);
        });
        duration = System.currentTimeMillis() - begin;
        System.out.println("foreach past " + duration);



        begin = System.currentTimeMillis();
        longs.stream().forEach(i -> {
            compute(i);
        });
        duration = System.currentTimeMillis() - begin;
        System.out.println("stream foreach past " + duration);
    }

    private static void compute(Long i) {
        for (int i1 = 0; i1 < 10; i1++) {
            i++;
            if (i == -1) {
                throw new RuntimeException();
            }
        }
    }
}
