package com.study.basic.module.thread;

/**
 * @author dzp 2021/3/30
 */
public class VolatileDemo {


    private static boolean stop = false;
    private volatile static boolean stopVolatile = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("res:" + i);
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;

//        method01();
//        method02();
//        method03();
//        method04();
    }


    private static void method01() throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("res:" + i);
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;
    }

    private static void method02() throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 0;
            while (!stop) {
                i++;
                System.out.println("res:" + i);
            }

        });
        thread.start();
        Thread.sleep(1000);
        stop = true;

    }

    private static void method03() throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 0;
            while (!stopVolatile) {
                i++;
            }
            System.out.println("res:" + i);
        });
        thread.start();
        Thread.sleep(1000);
        stopVolatile = true;
    }

    private static void method04() throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 0;
            while (!stop) {
                i++;
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("res:" + i);
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;

    }

}
