package com.ysan.auth.service;

import com.ysan.auth.domain.AuthCode;
import com.ysan.auth.domain.User;

/**
 * @author Administrator
 * @description
 * @since 2023/3/14 17:05
 **/
public interface UserService {
    void addUser(User user);
    void auth(User user);
    boolean check(AuthCode authCodeToValidate);
    void generateOrRenewAutoCode(User u);
}
