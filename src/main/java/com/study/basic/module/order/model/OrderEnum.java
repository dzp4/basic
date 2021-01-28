package com.study.basic.module.order.model;

/**
 * @author dzp 2020/8/29
 */
public enum OrderEnum {

    /**
     * 集采单
     */
    FOCUS("10",4),

    /**
     * 申购单
     */
    APPLY("11",4),

    /**
     * 采购单
     */
    PURCHASE("12",4),

    /**
     * 订单
     */
    ORDER("13",4),

    /**
     * 配送单
     */
    DELIVERY("14",4),

    /**
     * 报价单
     */
    QUOTATION("15",6),

    /**
     * 应标单
     */
    BID("16",6);

    /**
     * 前缀
     */
    public String prefix;

    /**
     * 后缀随机数长度
     */
    public int suffixLen;

    /**
     * @param prefix    前缀
     * @param suffixLen 后缀随机数长度
     */
    OrderEnum(String prefix, int suffixLen) {
        this.prefix = prefix;
        this.suffixLen = suffixLen;
    }

}
