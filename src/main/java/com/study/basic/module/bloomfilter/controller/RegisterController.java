package com.study.basic.module.bloomfilter.controller;

import com.study.basic.module.bloomfilter.model.bo.CreateAccountBO;
import com.study.basic.module.bloomfilter.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 布隆过滤器
 *
 * @author dzp 2020/11/17
 */
@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/create")
    @ApiOperation("创建账号，用布隆过滤器判断账号是否存在")
    public String create(CreateAccountBO bo) {
        return registerService.create(bo);
    }


}
