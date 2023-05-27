package com.charwayh.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: create by CharwayH
 * @description: com.charwayh.config
 * @date:2023/5/27
 */
@Configuration
public class RedisConfig {
    @Bean
    public Redisson redisson(){
        // 单机模式
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.181:6379")
                .setDatabase(0)
                .setPingConnectionInterval(1000);
        // 设置分布式锁watchDog超时时间
        return (Redisson) Redisson.create(config);
    }
}
