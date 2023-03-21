package com.ysan.jwt.config;

import com.ysan.jwt.interceptors.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 15:00
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor())
                .addPathPatterns("/**"); // 拦截所有请求，
    }

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }
}
