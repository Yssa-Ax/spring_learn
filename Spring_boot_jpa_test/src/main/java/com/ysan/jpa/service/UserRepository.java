package com.ysan.jpa.service;

import com.ysan.jpa.entity.EmailAddress;
import com.ysan.jpa.entity.User;
import com.ysan.jpa.repository.MyBaseRepository;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 15:13
 **/
public interface UserRepository extends MyBaseRepository<User, Long> {
    User findByEmailAddress(EmailAddress emailAddress);
}
