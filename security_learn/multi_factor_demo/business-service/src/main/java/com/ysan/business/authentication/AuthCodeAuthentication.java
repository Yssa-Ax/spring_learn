package com.ysan.business.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Administrator
 * @description
 * @since 2023/3/15 13:22
 **/
public class AuthCodeAuthentication extends UsernamePasswordAuthenticationToken {
    public AuthCodeAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
