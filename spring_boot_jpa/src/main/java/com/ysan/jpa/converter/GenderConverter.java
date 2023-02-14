package com.ysan.jpa.converter;

import com.ysan.jpa.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Administrator
 * @description
 * @since 2023/2/6 16:16
 **/
@Converter
public class GenderConverter implements AttributeConverter<Gender, Character> {
    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        if (gender == null) {
            return null;
        }
        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character character) {
        if (character == null) {
            return null;
        }
        return Gender.fromCode(character);
    }
}
