package com.ysan.jpa.embeddable;

import javax.persistence.Embeddable;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 11:04
 **/

@Embeddable
public class Publisher {
    private String name;

    private Location location;

    public Publisher(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    private Publisher() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
