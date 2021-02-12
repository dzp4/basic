package com.study.basic.module.dir;

/**
 * @author dzp 2021/2/11
 */
public enum FileSizeEnum {

    /**
     * 1b
     */
    B(1, 1024, "B"),

    /**
     * 1kb
     */
    KB(1024, 1048576, "KB"),

    /**
     * 1mb
     */
    M(1048576, 1073741824, "M"),

    /**
     * 1gb
     */
    G(1073741824, 1099511627776L, "GB"),
    ;

    /**
     * 换算成b需要除以多少
     */
    public long convert;

    /**
     * 大小，单位b
     */
    public long size;

    /**
     * 单位
     */
    public String unit;

    FileSizeEnum(long convert, long size, String unit) {
        this.convert = convert;
        this.unit = unit;
        this.size = size;
    }

}
