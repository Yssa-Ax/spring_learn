package com.ysan.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 15:24
 **/
@Entity
@Table(name = "t_email")
@Data
public class EmailAddress {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "address")
    private String address;
}
