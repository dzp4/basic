package com.study.basic.design.singleton.hungry;

import com.study.basic.design.singleton.SingletonTest;
import com.study.basic.module.design.singleton.hungry.HungrySingleton;
import org.junit.jupiter.api.Test;

/**
 * @author dzp 2021/3/30
 */

public class HungrySingletonTest implements SingletonTest {

    @Test
    @Override
    public void testSingletonSafe() {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    @Test
    @Override
    public void testTheadSafe() {
        Thread t1 = new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        });

        Thread t2 = new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        });

        t1.start();
        t2.start();
    }

    @Test
    @Override
    public void testReflectSafe() {
        // 此单例必然会被反射破坏

    }

    @Test
    @Override
    public void testSerializableSafe() {
        // 此处必然会被序列化破坏
    }
}
