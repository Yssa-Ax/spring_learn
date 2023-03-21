package com.ysan.auth2.filter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator
 * @description
 * @since 2023/3/17 16:42
 **/
@Component
public class AuthorizationHeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        AuthorizationHeaderHolder.getAuthorizationHeader().setAuthorizationHeader(httpServletRequest.getHeader(AuthorizationHeader.AUTHORIZATION_HEADER));
        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
