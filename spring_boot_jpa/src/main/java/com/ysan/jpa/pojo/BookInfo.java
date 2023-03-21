package com.ysan.jpa.pojo;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 14:44
 **/
@Entity(name = "BookInfo")
public class BookInfo {
    private Long id;

    private String title;

    private String author;

    @Access( AccessType.FIELD )
    @Version
    private int version;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
