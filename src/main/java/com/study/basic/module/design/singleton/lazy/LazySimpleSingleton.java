package com.study.basic.module.design.singleton.lazy;

/**
 * 简单的懒汉式单例
 * 优点：节省了内存，用到才实例化
 * 缺点：初始化时候先线程不安全
 * @author dzp 2021/3/30
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton instance;

    /**
     * 构造方法私有化
     */
    private LazySimpleSingleton() {

    }

    /**
     * 全局唯一的访问点
     *
     * @return LazySimpleSingleton
     */
    public static LazySimpleSingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSingleton();
        }
        return instance;
    }

}
