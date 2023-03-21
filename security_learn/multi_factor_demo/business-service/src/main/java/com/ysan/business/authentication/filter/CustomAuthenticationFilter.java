package com.ysan.business.authentication.filter;

import com.ysan.business.authentication.AuthCodeAuthentication;
import com.ysan.business.authentication.UsernamePasswordAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Administrator
 * @description
 * @since 2023/3/15 13:17
 **/

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Lazy
    @Autowired
    private AuthenticationManager manager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");

        if (code == null) {
            Authentication a = new UsernamePasswordAuthentication(username, password);
            manager.authenticate(a);
        } else {
            Authentication a = new AuthCodeAuthentication(username, code);
            manager.authenticate(a);

            String token = UUID.randomUUID().toString();
            response.setHeader("Authorization", token);
        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/login");
    }
}