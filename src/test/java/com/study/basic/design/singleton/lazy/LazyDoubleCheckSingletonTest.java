package com.study.basic.design.singleton.lazy;

import com.study.basic.design.singleton.SingletonTest;
import com.study.basic.module.design.singleton.hungry.HungrySingleton;
import com.study.basic.module.design.singleton.lazy.LazyDoubleCheckSingleton;
import com.study.basic.module.design.singleton.lazy.LazyStaticInnerClassSingleton;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author dzp 2021/3/30
 */
public class LazyDoubleCheckSingletonTest implements SingletonTest {


    @Test
    @Override
    public void testSingletonSafe() {
        LazyDoubleCheckSingleton instance1 = LazyDoubleCheckSingleton.getInstance();
        LazyDoubleCheckSingleton instance2 = LazyDoubleCheckSingleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    @Test
    @Override
    public void testTheadSafe() {
        Thread t1 = new Thread(() -> {
            LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
            System.out.println(instance);
        });
        Thread t2 = new Thread(() -> {
            LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
            System.out.println(instance);
        });
        t1.start();
        t2.start();
    }

    @Test
    @Override
    public void testReflectSafe() {

        Class<?> cla = LazyDoubleCheckSingleton.class;
        Constructor<?> declaredConstructor;
        Object instance1 = null;
        Object instance2 = null;
        try {
            declaredConstructor = cla.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            instance1  = declaredConstructor.newInstance();
            instance2 = declaredConstructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(instance1);
        System.out.println(instance2);
    }

    @Test
    @Override
    public void testSerializableSafe() {
        String name = "serializable.obj";
        LazyDoubleCheckSingleton instance1;
        LazyDoubleCheckSingleton instance2 = LazyDoubleCheckSingleton.getInstance();

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fos = new FileOutputStream(name);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            fos.flush();
            oos.flush();

            fis = new FileInputStream(name);
            ois = new ObjectInputStream(fis);
            instance1 = (LazyDoubleCheckSingleton) ois.readObject();

            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
