package com.ysan.jpa.converter;

import com.ysan.jpa.pojo.Money;

import javax.persistence.AttributeConverter;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:47
 **/
public class MoneyConverter implements AttributeConverter<Money, Long> {
    @Override
    public Long convertToDatabaseColumn(Money money) {
        return money == null ? null : money.getCents();
    }

    @Override
    public Money convertToEntityAttribute(Long aLong) {
        return aLong == null ? null : new Money(aLong);
    }
}
