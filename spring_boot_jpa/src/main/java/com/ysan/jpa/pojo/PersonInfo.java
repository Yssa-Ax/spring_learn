package com.ysan.jpa.pojo;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 17:34
 **/
@Entity(name = "PersonInfo")
public class PersonInfo {
    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
