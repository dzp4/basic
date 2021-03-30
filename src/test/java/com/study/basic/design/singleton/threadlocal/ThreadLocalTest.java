package com.study.basic.design.singleton.threadlocal;

import com.study.basic.design.singleton.SingletonTest;
import com.study.basic.module.design.singleton.threadlocal.ThreadLocalSingleton;
import org.junit.jupiter.api.Test;

/**
 * @author dzp 2021/3/30
 */
public class ThreadLocalTest implements SingletonTest {

    @Test
    @Override
    public void testSingletonSafe() {
        ThreadLocalSingleton instance1 = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton instance2 = ThreadLocalSingleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    @Test
    @Override
    public void testTheadSafe() {
        Thread t1 = new Thread(() -> {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(instance);
        });

        Thread t2 = new Thread(() -> {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(instance);
        });

        t1.start();
        t2.start();


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
