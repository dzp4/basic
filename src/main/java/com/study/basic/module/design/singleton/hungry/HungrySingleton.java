package com.study.basic.module.design.singleton.hungry;

import com.study.basic.module.design.singleton.ResolveSerializable;

import java.io.Serializable;

/**
 * 饿汉式单例模式
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：类初始化就创建，如果使用不上就会造成内存浪费，如果工程中所有的类都这样初始化，那么内存极大的浪费
 *
 * @author dzp 2021/3/30
 */
public class HungrySingleton {

    /**
     * 在字段初始化就赋值
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 构造方法私有化（隐藏所有创建方法）
     */
    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }


}
