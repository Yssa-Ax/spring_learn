package com.ysan.jpa.pojo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 9:48
 **/
@Entity(name = "Event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
