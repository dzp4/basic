package com.study.basic.module.thread;

/**
 * @author dzp 2021/3/28
 */
public class Count {

    public static int count = 0;

    public static void incr() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(Count::incr).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果:" + count);
    }

}
