package com.ysan.mp.mapper;

import com.ysan.mp.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author ysan
 * @since 2023-02-15
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    void deleteAll();
}
