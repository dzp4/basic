package com.study.basic.module.design.singleton.lazy;

/**
 * @author dzp 2021/3/30
 */
public class LazySynchronizedSingleton {


    private static LazySynchronizedSingleton instance;

    /**
     * 构造方法私有化
     */
    private LazySynchronizedSingleton() {

    }

    /**
     * 全局唯一的访问点
     * 比simple多一个synchronized，也就是加锁，保证实例化时候不会被覆盖，但是性能下降
     *
     * @return LazySynchronizedSingleton
     */
    public synchronized static LazySynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new LazySynchronizedSingleton();
        }
        return instance;
    }

}
