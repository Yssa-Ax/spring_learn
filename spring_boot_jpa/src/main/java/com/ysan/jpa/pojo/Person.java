package com.ysan.jpa.pojo;

import com.ysan.jpa.converter.GenderConverter;
import com.ysan.jpa.enums.Gender;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:14
 **/
@Entity(name = "Person")
public class Person {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName1;

    private String middleName2;

    private String middleName3;

    private String middleName4;

    private String middleName5;

    @Generated(value = GenerationTime.ALWAYS)
    @Column(columnDefinition =
            "VARCHAR ( 255 ) AS (CONCAT(" +
                    "	COALESCE(first_name, ''), " +
                    "	COALESCE(' ' + middle_name1, ''), " +
                    "	COALESCE(' ' + middle_name2, ''), " +
                    "	COALESCE(' ' + middle_name3, ''), " +
                    "	COALESCE(' ' + middle_name4, ''), " +
                    "	COALESCE(' ' + middle_name5, ''), " +
                    "	COALESCE(' ' + last_name, '') " +
                    "))")
    private String fullName;

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

    public String getMiddleName1() {
        return middleName1;
    }

    public void setMiddleName1(String middleName1) {
        this.middleName1 = middleName1;
    }

    public String getMiddleName2() {
        return middleName2;
    }

    public void setMiddleName2(String middleName2) {
        this.middleName2 = middleName2;
    }

    public String getMiddleName3() {
        return middleName3;
    }

    public void setMiddleName3(String middleName3) {
        this.middleName3 = middleName3;
    }

    public String getMiddleName4() {
        return middleName4;
    }

    public void setMiddleName4(String middleName4) {
        this.middleName4 = middleName4;
    }

    public String getMiddleName5() {
        return middleName5;
    }

    public void setMiddleName5(String middleName5) {
        this.middleName5 = middleName5;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
