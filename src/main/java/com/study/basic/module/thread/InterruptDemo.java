package com.study.basic.module.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author dzp 2021/3/27
 */
public class InterruptDemo implements Runnable {

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {
                // thread.interrupt()会进入到这里
                // 如果在这里不做任何处理，会将线程复位，即isInterrupted() = false
                e.printStackTrace();
                // 外面调用的interrupt只能catch，这里调用的将会直接结束当前线程
                // 假如注释掉这行代码，那么线程不会结束
//                Thread.currentThread().interrupt();
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        Thread.sleep(200);
        thread.interrupt();
    }

}
