package com.charwayh.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: create by CharwayH
 * @description: com.charwayh.controller
 * @date:2023/5/27
 */
@RestController
@RequestMapping("/redisson")
public class RedissonController {
    @Autowired
    private Redisson redisson;
    public static final String REDIS_LOCK = "good_lock";

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        RLock redissonLock = redisson.getLock(REDIS_LOCK);
        // 加锁
        redissonLock.lock(10, TimeUnit.SECONDS);
        System.out.println("Do Something..");
        // 释放锁
        redissonLock.unlock();
        // 抢购成功
        return "抢购成功";
    }
}
