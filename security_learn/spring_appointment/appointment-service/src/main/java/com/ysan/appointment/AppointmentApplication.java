package com.ysan.appointment;

import com.ysan.appointment.filter.AuthorizationHeaderInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class AppointmentApplication {

    @Primary
    @Bean
    @LoadBalanced
    public RestTemplate getCustomRestTemplate() {
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors == null) {
            template.setInterceptors(Collections.singletonList(new AuthorizationHeaderInterceptor()));
        } else {
            interceptors.add(new AuthorizationHeaderInterceptor());
            template.setInterceptors(interceptors);
        }

        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppointmentApplication.class, args);
    }

}
