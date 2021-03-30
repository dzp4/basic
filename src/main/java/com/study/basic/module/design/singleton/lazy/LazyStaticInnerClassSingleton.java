package com.study.basic.module.design.singleton.lazy;

/**
 *
 * LazyStaticInnerClassSingleton.class
 * LazyStaticInnerClassSingleton$LazyHolder.class
 *
 * 优点：写法优雅，利用了java本身语法特点，比Double性能高，避免了内存浪费
 * 缺点：能够被反射破坏
 * @author dzp 2021/3/30
 */
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton() {
        // 解决反射破坏
        throw new RuntimeException("非法访问");
    }

    private static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }



}
