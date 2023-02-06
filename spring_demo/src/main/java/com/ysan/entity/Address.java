package com.ysan.entity;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 16:08
 **/
public class Address {
    private long id;
    private String name;

    public Address() {
        System.out.println("无参构造函数创建-Address");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
