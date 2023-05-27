package com.charwayh.hellospringbootredis;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableApolloConfig
public class HelloSpringbootRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootRedisApplication.class, args);
    }
}
