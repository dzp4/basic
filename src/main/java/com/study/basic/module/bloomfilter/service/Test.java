package com.study.basic.module.bloomfilter.service;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.lang.Assert;

/**
 * @author dzp 2020/11/10
 */
public class Test {


    public static void main(String[] args) {
        // 布隆过滤器说不在，那就一定不在
        // 布隆过滤器说在，那就不一定在

        // 初始化
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");

        // 查找
        boolean exist1 = filter.contains("abc");
        boolean exist2 = filter.contains("abc1");
        System.out.println(exist1);
        System.out.println(exist2);




    }

}
