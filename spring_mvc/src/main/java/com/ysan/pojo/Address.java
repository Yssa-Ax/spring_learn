package com.ysan.pojo;

/**
 * @author Administrator
 * @description
 * @since 2023/2/1 10:50
 **/
public class Address {
    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "code=" + code +
                ", name='" + value + '\'' +
                '}';
    }
}
