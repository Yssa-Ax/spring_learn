package com.ysan.jpa.pojo;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:46
 **/
public class Money {
    private long cents;

    public Money(long cents) {
        this.cents = cents;
    }

    public long getCents() {
        return cents;
    }

    public void setCents(long cents) {
        this.cents = cents;
    }
}
