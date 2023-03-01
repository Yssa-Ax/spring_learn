package com.ysan.pojo;
import lombok.*;

@Getter
@Setter
// 创建一个无参构造函数
@NoArgsConstructor
// 添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
@ToString
public class Student {

    private Integer id;

    private String name;

    private Integer score;

    private Integer age;

    private Integer gender;

}


