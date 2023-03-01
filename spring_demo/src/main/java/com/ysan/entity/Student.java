package com.ysan.entity;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 15:44
 **/
public class Student {
    private long id;
    private String name;
    private int age;
    private Address address;
    private Classes classes;

    public Student() {
        System.out.println("无参构造函数创建-Student");
    }

    public Student(long id, String name) {
        System.out.println("有参构造函数创建");
        this.id = id;
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", classes=" + classes +
                '}';
    }
}
