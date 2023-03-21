package com.ysan.redissonTest.repository;

import com.ysan.redissonTest.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CourseRepository extends JpaSpecificationExecutor<CourseModel>, JpaRepository<CourseModel, Integer> {
}
