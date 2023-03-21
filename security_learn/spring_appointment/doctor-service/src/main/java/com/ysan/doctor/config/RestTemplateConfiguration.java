package com.ysan.doctor.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:17
 **/
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    // @LoadBalanced 让这个RestTemplate在请求时拥有客户端负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
