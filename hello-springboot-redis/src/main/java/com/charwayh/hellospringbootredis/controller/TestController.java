package com.charwayh.hellospringbootredis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by CharwayH
 * @description: com.charwayh.hellospringbootredis.controller
 * @date:2023/5/19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${redis.host}")
    private String host;

    @RequestMapping("/redis")
    public String show(){
        return host;
    }
}
