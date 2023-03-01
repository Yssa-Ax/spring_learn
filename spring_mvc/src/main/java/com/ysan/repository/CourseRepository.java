package com.ysan.repository;

import com.ysan.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepository {
    private Map<Integer, Course> map;
    public CourseRepository(){
        map=new HashMap<>();
        map.put(1, new Course(1,"语文",70.0));
        map.put(2, new Course(2,"数学",80.0));
        map.put(3, new Course(3,"英语",90.0));
    }

    public Collection<Course> findAll(){
        return map.values();
    }
    public Course findById(Integer id){
        return map.get(id);
    }
    public void saveOrUpdate(Course course){
        map.put(course.getId(), course);
    }
    public void deleteById(Integer id){
        map.remove(id);
    }

}

