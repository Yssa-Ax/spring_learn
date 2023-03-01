package com.ysan.jpa.embeddable;

import javax.persistence.Embeddable;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 11:28
 **/

@Embeddable
public class Location {
    private String country;

    private String city;

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    private Location() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
