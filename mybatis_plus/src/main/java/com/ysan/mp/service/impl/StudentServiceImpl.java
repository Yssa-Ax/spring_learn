package com.ysan.mp.service.impl;

import com.ysan.mp.pojo.Student;
import com.ysan.mp.mapper.StudentMapper;
import com.ysan.mp.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author ysan
 * @since 2023-02-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
