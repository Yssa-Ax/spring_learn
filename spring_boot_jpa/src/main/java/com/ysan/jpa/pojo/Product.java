package com.ysan.jpa.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 13:44
 **/
@Entity(name = "Product")
public class Product {

    @Id
    @Basic
    private Integer id;

    @Basic
    private String sku;

    @Basic
    private String name;

    @Basic
    @Column(name = "NOTES")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
