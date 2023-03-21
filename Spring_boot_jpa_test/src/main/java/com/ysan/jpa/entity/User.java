package com.ysan.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 15:23
 **/
@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "pwd")
    private String pwd;
}
