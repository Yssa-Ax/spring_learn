package com.ysan.converter;

import com.ysan.pojo.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Administrator
 * @description
 * @since 2023/2/1 17:10
 **/
public class StudentConverter implements Converter<String, Student> {
    @Override
    public Student convert(String source) {
        String[] args = source.split("-");
        Student student = new Student();

        student.setId(Integer.parseInt(args[0]));
        student.setName(args[1]);
        student.setAge(Integer.parseInt(args[2]));
        return student;
    }
}
