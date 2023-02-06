package com.ysan.mapper;

import com.ysan.pojo.Student;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/3 9:50
 **/
public interface StudentMapper {
    List<Student> findAll();

    int insert(Student student);

    int delete(Integer id);

    List<Student> findByName(String value);

    List<Student> batchFind(List<Integer> list);

}