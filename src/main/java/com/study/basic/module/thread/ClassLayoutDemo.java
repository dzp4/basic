package com.study.basic.module.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author dzp 2021/3/28
 */
public class ClassLayoutDemo {

    // -XX:-UseComparessedOops 关闭压缩指针
    public static void main(String[] args) {
        ClassLayoutDemo demo = new ClassLayoutDemo();
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
    }

}
