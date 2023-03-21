package com.ysan.jwt.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ysan.jwt.utils.JJWTUtils;
import com.ysan.jwt.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 14:46
 **/


public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 地址过滤
        String uri = request.getRequestURI();
        if (uri.contains("/login")){
            return true;
        }

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        if(StringUtils.isEmpty(token)){
            throw new SignatureException("token"+ "不能为空");
        }

        try {
            // 1.校验JWT字符串
            DecodedJWT decodedJWT = JWTUtils.decode(token);
            // 2.取出JWT字符串载荷中的随机token，从Redis中获取用户信息 或者 其他处理
            String key = decodedJWT.getClaim("key").asString();
            System.out.println("用户JWT中key：" + key );
            request.setAttribute("identityId", key);
            return true;
        }catch (SignatureVerificationException e){
            System.out.println("无效签名");
            e.printStackTrace();
        }catch (TokenExpiredException e){
            System.out.println("token已经过期");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            System.out.println("算法不一致");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("token无效");
            e.printStackTrace();
        }
        return false;
    }
}
