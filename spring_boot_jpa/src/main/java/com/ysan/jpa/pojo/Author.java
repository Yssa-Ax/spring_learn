package com.ysan.jpa.pojo;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/8 9:35
 **/
@Entity
@Table(name = "author",
        indexes = @Index(
                name = "idx_author_first_last",
                columnList = "first_name, last_name",
                unique = false
        ))
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
