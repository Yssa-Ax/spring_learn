package com.ysan.auth.controller;

import com.ysan.auth.domain.AuthCode;
import com.ysan.auth.domain.User;
import com.ysan.auth.service.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrators
 * @description
 * @since 2023/3/14 17:03
 **/

@RestController
public class AuthController {

    @Autowired
    private UserService userService;


    // 添加User
    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    // 通过用户名+密码对用户进行首次认证
    @PostMapping("/user/auth")
    public void auth(@RequestBody User user){
        userService.auth(user);
    }

    // 通过用户名+认证码进行二次认证
    @PostMapping("/authcode/check")
    public void check(@RequestBody AuthCode authCode, HttpServletResponse response) {
        if (userService.check(authCode)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
