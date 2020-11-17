package com.study.basic.module.bloomfilter.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dzp 2020/11/17
 */
@Data
public class CreateAccountBO {

    @ApiModelProperty(value = "账号", required = true)
    private String account;

}
