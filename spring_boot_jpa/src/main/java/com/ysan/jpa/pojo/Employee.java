package com.ysan.jpa.pojo;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 10:20
 **/
@Entity(name = "Employee")
public class Employee {

    @Id
    private Long id;

    @NaturalId
    private String username;

    @Column(name = "pswd")
    @ColumnTransformer(
            read = "decrypt('AES', '00', pswd)",
            write = "encrypt('AES', '00', ?')"
    )
    private String password;

    private int accessLevel;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
