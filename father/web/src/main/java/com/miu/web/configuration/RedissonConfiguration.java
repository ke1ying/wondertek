package com.miu.web.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient getRedisson(){
        //默认创建的是没有密码的本机redis
        return Redisson.create();
    }
}
