package com.ysan.redissonTest.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @description
 * @since 2023/2/28 11:22
 **/
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient getRedisson() throws Exception {
        RedissonClient redisson = null;
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://49.235.108.159:6379");
        redisson = Redisson.create(config);
        System.out.println(redisson.getConfig().toJSON().toString());
        return redisson;
    }
}
