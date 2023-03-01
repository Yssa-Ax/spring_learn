package com.ysan.jpa.pojo;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 15:32
 **/
@Entity(name = "PhoneDetails")
public class PhoneDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    private Phone phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
