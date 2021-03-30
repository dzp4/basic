package com.study.basic.module.design.singleton.lazy;

import com.study.basic.module.design.singleton.ResolveSerializable;

import java.io.Serializable;

/**
 * 优点：性能高了，线程安全了
 * 缺点：代码不够优雅
 *
 * @author dzp 2021/3/30
 */
public class LazyDoubleCheckSingleton implements ResolveSerializable, Serializable {

    /**
     * 不加volatile会出现线程紊乱
     */
    private static volatile LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {
        // 解决反射破坏
        throw new RuntimeException("非法访问");
    }

    public static LazyDoubleCheckSingleton getInstance() {
        // 双重判断
        // 这里判断是否要加锁
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                // 这里判断是否要创建实例
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public Object readResolve() {
        return getInstance();
    }

}
