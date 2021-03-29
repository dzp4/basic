package com.study.basic.module.thread;

import java.util.Queue;

/**
 * @author dzp 2021/3/29
 */
public class Consumer implements Runnable {

    private final Queue<String> msg;

    public Consumer(Queue<String> msg) {
        this.msg = msg;
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
        while (true) {
            synchronized (msg) {
                while (msg.isEmpty()) {
                    // 如果队列没消息了，消费者将进入等待状态
                    msg.wait();
                }
                Thread.sleep(200);
                System.out.println("消费者消费消息：" + msg.remove());
                msg.notify();
            }
        }
    }


}
