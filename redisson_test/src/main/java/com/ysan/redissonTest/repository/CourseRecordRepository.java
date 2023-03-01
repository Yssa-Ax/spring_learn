package com.ysan.redissonTest.repository;

import com.ysan.redissonTest.model.CourseRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CourseRecordRepository extends JpaSpecificationExecutor<CourseRecordModel>, JpaRepository<CourseRecordModel, Integer> {
}
