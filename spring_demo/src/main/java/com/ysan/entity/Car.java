package com.ysan.entity;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 17:35
 **/
public class Car {
    private Integer num;
    private String brand;

    public Car() {
    }

    public Car(Integer num, String brand) {
        this.num = num;
        this.brand = brand;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num=" + num +
                ", brand='" + brand + '\'' +
                '}';
    }
}


