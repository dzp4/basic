package com.study.basic.module.thread;

/**
 * @author dzp 2021/3/27
 */
public class InterruptDemo02 implements Runnable {

    static volatile boolean interrupt = false;

    @Override
    public void run() {

        while (!interrupt) {
            System.out.println("running");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo02());
        thread.start();
        Thread.sleep(300);
        interrupt = true;
    }


}
