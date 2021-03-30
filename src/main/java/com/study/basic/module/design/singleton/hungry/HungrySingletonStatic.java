package com.study.basic.module.design.singleton.hungry;

/**
 * @author dzp 2021/3/30
 */
public class HungrySingletonStatic {

    /**
     * 类加载顺序：先静态后动态
     * 先上后下
     * 先属性后方法
     */
    private static final HungrySingletonStatic hungrySingletonStatic;

    // 和HungrySingleton没有本质区别
    static {
        hungrySingletonStatic = new HungrySingletonStatic();
    }

    private HungrySingletonStatic() {

    }

    private static HungrySingletonStatic getInstance() {
        return hungrySingletonStatic;
    }

}
