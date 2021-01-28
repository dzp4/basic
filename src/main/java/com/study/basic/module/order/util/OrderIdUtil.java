package com.study.basic.module.order.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.basic.module.order.model.OrderEnum;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author dzp 2021/1/28
 */
public class OrderIdUtil {

    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        String orderId = getOrderId(OrderEnum.BID);
        System.out.println(orderId);
        // 花费毫秒数
        System.out.println(timer.interval());
    }

    /**
     * 获取一个随机的订单ID
     *
     * @param orderEnum 订单枚举
     * @return 订单ID
     */
    private static String getOrderId(OrderEnum orderEnum) {
        // todo 存到redis
        // 此处应该从redis中拿，如果从redis拿不到（过期了），那就init到redis
        HashMap<String, List<String>> stringListHashMap = initIdList();
        List<String> strings = stringListHashMap.get(orderEnum.name());
        String ele = RandomUtil.randomEle(strings);
        strings.remove(ele);
        return ele;
    }

    /**
     * 穷举所有的订单ID
     *
     * @return 穷举所有的订单ID
     */
    public static HashMap<String, List<String>> initIdList() {
        OrderEnum[] values = OrderEnum.values();
        HashMap<String, List<String>> orderIdMap = Maps.newHashMapWithExpectedSize(values.length);
        String date = DateUtil.format(DateUtil.date(), "yyyyMMdd");
        for (OrderEnum value : values) {
            String name = value.name();
            List<String> allNumber = getAllNumber(value.prefix, date, value.suffixLen);
            orderIdMap.put(name, allNumber);
        }
        return orderIdMap;
    }

    /**
     * 穷举所有的订单号
     *
     * @param pre    前缀
     * @param date   中间时间
     * @param length 后面的随机数长度
     * @return 穷举所有的订单号
     */
    private static List<String> getAllNumber(String pre, String date, int length) {
        List<String> ids = Lists.newArrayList();
        BigDecimal pow = NumberUtil.pow(10, length);
        for (int j = 1; j < pow.intValue() + 1; j++) {
            String number = NumberUtil.decimalFormat("0000", j);
            ids.add(pre + date + number);
        }
        return ids;
    }

}
