package com.study.basic.module.design.singleton;

/**
 * @author dzp 2021/3/30
 */
public interface ResolveSerializable {

    /**
     * 解决序列化破坏单例
     *
     * @return 单例实例
     */
    Object readResolve();

}
