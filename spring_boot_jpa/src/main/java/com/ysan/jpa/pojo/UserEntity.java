package com.ysan.jpa.pojo;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 14:05
 **/
@Entity
//@Table(name = "`user`", catalog = "jpa")
@Table(name = "`user`")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "username")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
