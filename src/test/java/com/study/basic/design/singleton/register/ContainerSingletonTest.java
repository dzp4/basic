package com.study.basic.design.singleton.register;

import com.study.basic.design.singleton.SingletonTest;
import com.study.basic.module.design.singleton.register.ContainerSingleton;
import org.junit.jupiter.api.Test;

/**
 * @author dzp 2021/3/30
 */
public class ContainerSingletonTest implements SingletonTest {

    @Test
    @Override
    public void testSingletonSafe() {
        String className = "com.study.basic.module.bloomfilter.service.RegisterService";
        Object instance1 = ContainerSingleton.getInstance(className);
        Object instance2 = ContainerSingleton.getInstance(className);
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    // todo 线程中无法输出内容
    @Test
    @Override
    public void testTheadSafe() {
        String className = "com.study.basic.module.bloomfilter.service.RegisterService";
        Thread t1 = new Thread(() -> {
            Object instance = ContainerSingleton.getInstance(className);
            System.out.println(instance);
            System.out.println(Thread.currentThread().getName());
        });

        Thread t2 = new Thread(() -> {
            Object instance = ContainerSingleton.getInstance(className);
            System.out.println(instance);
            System.out.println(Thread.currentThread().getName());
        });

        t1.start();
        t2.start();
        System.out.println("main end");
    }

    @Test
    @Override
    public void testReflectSafe() {

    }

    @Test
    @Override
    public void testSerializableSafe() {

    }

}
