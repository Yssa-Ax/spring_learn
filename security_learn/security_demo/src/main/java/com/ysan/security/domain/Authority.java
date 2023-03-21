package com.ysan.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/3/6 16:08
 **/

@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;
}
