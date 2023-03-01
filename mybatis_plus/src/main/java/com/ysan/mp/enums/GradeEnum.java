package com.ysan.mp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Administrator
 * @description
 * @since 2023/2/16 14:26
 **/
public enum  GradeEnum {
    PRIMARY(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高学"),
    ;

    private int code;
    @EnumValue // 描述作为枚举值保持到数据库
    private String desc;



    GradeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
