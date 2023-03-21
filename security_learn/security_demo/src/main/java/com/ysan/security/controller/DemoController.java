package com.ysan.security.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description
 * @since 2023/3/2 15:30
 **/

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        PasswordEncoder p1 = new SCryptPasswordEncoder(16384, 8, 1, 32, 64);
        System.out.println(p1.upgradeEncoding("123"));
        return "Hello World!";
    }
}
