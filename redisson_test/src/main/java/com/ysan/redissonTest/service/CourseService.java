package com.ysan.redissonTest.service;

import com.ysan.redissonTest.model.CourseModel;

/**
 * @author Administrator
 * @description
 * @since 2023/2/28 11:33
 **/
public interface CourseService {
    CourseModel getById(Integer courseId);

    void upload(Integer userId, Integer courseId, Integer studyProcess);
}
