package com.ysan.mp.service.impl;

import com.ysan.mp.pojo.User;
import com.ysan.mp.mapper.UserMapper;
import com.ysan.mp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ysan
 * @since 2023-02-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
