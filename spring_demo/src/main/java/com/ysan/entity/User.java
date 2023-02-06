package com.ysan.entity;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 16:54
 **/
public class User {
    private Integer id;
    private String name;

    public User() {
        System.out.println("无参构造函数创建-User");
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
