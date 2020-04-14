package com.gaofei.log;

import org.slf4j.Logger;

import org.springframework.util.StopWatch;

/**
 * @author qingming.gqm
 * @date 2020/3/13
 */
public class StopWatchUtil {
    static ThreadLocal<StopWatch> local = new ThreadLocal<>();

    public static void start(String id) {
        if (local.get() == null) {
            local.set(new StopWatch(id));
        }
        if (!local.get().isRunning()) {
            local.get().start("init");
        }
    }

    public static void stop(Logger logger) {
        StopWatch sw = local.get();
        if (sw == null) {
            return;
        }
        if (sw.isRunning()) {
            sw.stop();
            System.out.println(sw.prettyPrint());
            //logger.info("{}", sw.prettyPrint());
        }
        local.remove();
    }

    public static void lap(String taskName) {
        StopWatch sw = local.get();
        if (sw == null) {
            return;
        }
        if (sw.isRunning()) {
            sw.stop();
            sw.start(taskName);
        }
        //无视未start的sw以避免内存泄露
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        StopWatchUtil.start("test");
        delay(100);
        System.out.println("test task run");
        //        StopWatchUtil.stop();

        StopWatchUtil.lap("test2");
        System.out.println("test2 task run");
        delay(200);
        StopWatchUtil.lap("test3");

        delay(100);
        StopWatchUtil.stop(null);
    }

    private static void delay(long time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
