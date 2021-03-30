package com.study.basic.module.design.singleton.register;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author dzp 2021/3/30
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<String, Object> ioc = Maps.newConcurrentMap();

    public static Object getInstance(String className) {
        if (ioc.containsKey(className)) {
            return ioc.get(className);
        }

        synchronized (ContainerSingleton.class) {
            if (ioc.containsKey(className)) {
                return ioc.get(className);
            }
            Object instance = null;
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return instance;
        }

    }
}
