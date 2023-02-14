package com.ysan.jpa.pojo;

import com.ysan.jpa.converter.MoneyConverter;

import javax.persistence.Convert;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:47
 **/
public class Account {
    private Long id;

    private String owner;

    @Convert( converter = MoneyConverter.class )
    private Money balance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
