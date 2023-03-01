package com.ysan.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 10:52
 **/
@Entity
@Table(name = "t_person")
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

}
