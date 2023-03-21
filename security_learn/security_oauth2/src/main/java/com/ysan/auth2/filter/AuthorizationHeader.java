package com.ysan.auth2.filter;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description
 * @since 2023/3/17 16:48
 **/

@Component
public class AuthorizationHeader {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private String authorizationHeader = new String();

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }
}
