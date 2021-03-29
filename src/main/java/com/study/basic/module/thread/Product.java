package com.study.basic.module.thread;

import java.util.Queue;

/**
 * @author dzp 2021/3/29
 */
public class Product implements Runnable {

    private final Queue<String> msg;
    private final int maxSize;

    public Product(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void method() throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            synchronized (msg) {
                while (msg.size() == maxSize) {
                    msg.wait();
                }
                Thread.sleep(1000);
                msg.add(String.valueOf(i));
                msg.notify();
                System.out.println("生产者生产消息" + i);
            }

        }

    }

}
