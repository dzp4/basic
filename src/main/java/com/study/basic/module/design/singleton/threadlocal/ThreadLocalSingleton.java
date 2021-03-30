package com.study.basic.module.design.singleton.threadlocal;

/**
 * 同一线程中一定是单例
 * 不同线程一定是不同的
 * 适用场景：多数据源错误日志，因为要相互隔离
 * @author dzp 2021/3/30
 */
public class ThreadLocalSingleton {

    public static final ThreadLocal<ThreadLocalSingleton> instance = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {

    }

    public static ThreadLocalSingleton getInstance() {
        return instance.get();
    }

}
