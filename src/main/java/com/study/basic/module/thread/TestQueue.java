package com.study.basic.module.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dzp 2021/3/29
 */
public class TestQueue {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        int maxSize = 5;

        Thread product = new Thread(new Product(queue, maxSize));
        Thread consumer = new Thread(new Consumer(queue));
        product.start();
        consumer.start();
    }

}
