package com.ysan.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/3/6 15:46
 **/
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private PasswordEncoderType passwordEncoderType;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;

}
