package com.study.basic.module.bloomfilter.service;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.study.basic.module.bloomfilter.model.bo.CreateAccountBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dzp 2020/11/17
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {

    private final BitMapBloomFilter FILTER = new BitMapBloomFilter(100);

    /**
     * 创建账号，用布隆过滤器校验账号是否存在
     *
     * @param bo 创建表单
     * @return String
     */
    public String create(CreateAccountBO bo) {
        Assert.notNull(bo, "参数为空！");
        String account = bo.getAccount();
        Assert.notBlank(account, "参数为空！");

        // 用布隆过滤器判断账号是否存在
        if (FILTER.contains(account)) {
            // 存在，需要查询数据库，看看数据是否真的存在
            log.info("查询数据库，判断是否存在");
            throw new IllegalArgumentException("账号存在！");
        } else {
            // 不存在，一定不存在
            log.info("直接创建");
            FILTER.add(account);
        }

        return "创建成功";
    }

}
