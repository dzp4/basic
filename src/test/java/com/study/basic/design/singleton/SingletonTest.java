package com.study.basic.design.singleton;

/**
 * @author dzp 2021/3/30
 */
public interface SingletonTest {

    /**
     * 测试是否单例
     */
    void testSingletonSafe();

    /**
     * 测试在多线程下是否单例
     */
    void testTheadSafe();

    /**
     * 测试反射是否能破坏单例
     */
    void testReflectSafe();

    /**
     * 测试序列化是否能破坏单例，在私有构造方法中抛出“非法访问”异常后，此方法也会抛出这个异常
     */
    void testSerializableSafe();



}
