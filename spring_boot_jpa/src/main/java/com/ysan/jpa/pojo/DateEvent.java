package com.ysan.jpa.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:54
 **/
@Entity(name = "DateEvent")
public class DateEvent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "timestamp1")
    @Temporal(TemporalType.DATE)
    private Date timestamp1;


    @Column(name = "timestamp2")
    @Temporal(TemporalType.TIME)
    private Date timestamp2;


    @Column(name = "timestamp3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Date timestamp1) {
        this.timestamp1 = timestamp1;
    }

    public Date getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(Date timestamp2) {
        this.timestamp2 = timestamp2;
    }

    public Date getTimestamp3() {
        return timestamp3;
    }

    public void setTimestamp3(Date timestamp3) {
        this.timestamp3 = timestamp3;
    }
}
