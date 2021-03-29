package com.study.basic.module.thread;

/**
 * @author dzp 2021/3/28
 */
public class SynchronizedDemo {

    // 只针对于当前对象实例有效
    synchronized void demo() {

    }

    void demo03() {
        synchronized (this) {

        }
    }

    // 类锁，针对所有对象都互斥
    synchronized static void demo04() {

    }

    void demo05() {
        synchronized (SynchronizedDemo.class) {

        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(demo::demo,"t1").start();
        new Thread(demo::demo,"t2").start();
    }

}
