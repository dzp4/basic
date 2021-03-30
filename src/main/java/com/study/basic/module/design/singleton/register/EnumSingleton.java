package com.study.basic.module.design.singleton.register;

/**
 * 枚举单例
 * 优点：线程安全，饿汉式，不会被反射破坏
 * 缺点：浪费内存，不适合在对象多的情景下使用
 *
 * @author dzp 2021/3/30
 */
public enum EnumSingleton {
    INSTANCE,
    ;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
