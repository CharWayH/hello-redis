package com.charwayh.hellospringbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/put")
    public String put(@RequestParam(required = true) String key,
                      @RequestParam(required = true) String value){
        redisTemplate.opsForValue().setIfAbsent(key,value,30000,TimeUnit.SECONDS);

        return "SUCCESS";
    }
    @RequestMapping("/get")
    public String get(@RequestParam String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/ttl")
    public Long ttl(@RequestParam String key){
        //return redisTemplate.opsForValue().getOperations().getExpire(key);
        return redisTemplate.getExpire(key);
    }


    @RequestMapping("/lpush")
    public String lpush(@RequestParam(required = true) String value){
        redisTemplate.opsForList().leftPush("list1",value);
        return "SUCCESS";
    }

    @RequestMapping("/hash")
    public String hash(){
        Map map = new HashMap();
        map.put("username","zhangsan");
        map.put("password","123456");
        map.put("age","23");

        redisTemplate.opsForHash().putAll("user",map);
        return "SUCCESS";
    }

    @RequestMapping("/showlist")
    public String showList(){
        return redisTemplate.opsForList().range("list1",0,-1).toString();
    }

    @RequestMapping("/showHash")
    public String showHash(){
        return redisTemplate.opsForHash().values("user").toString();
    }

    @RequestMapping("/showHashLen")
    public int showHashLen(){
        return redisTemplate.opsForHash().values("user").size();
    }

    @RequestMapping("/bitMap")
    public String bitMap(){
        return redisTemplate.opsForValue().get("user:sign:1000",20190101,20221231);
    }

}
