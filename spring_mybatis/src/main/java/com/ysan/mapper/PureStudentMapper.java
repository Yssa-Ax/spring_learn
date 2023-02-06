package com.ysan.mapper;

import com.ysan.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/3 10:07
 **/
public interface PureStudentMapper {


    @Select("SELECT * FROM t_students WHERE name like '%${name}%' AND major like '%${major}%'")
    List<Student> find(@Param("name") String name, @Param("major") String major);

    @Select("SELECT * FROM t_student")
    List<Student> findAll();

    @Insert("INSERT INTO t_student (name, age, score, gender) VALUES (#{name}, #{age}, #{score}, #{gender})")
    int insert(Student student);
}
