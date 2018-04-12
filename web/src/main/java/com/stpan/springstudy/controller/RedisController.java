package com.stpan.springstudy.controller;

import com.stpan.springstudy.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:  STPAN
 * time:    2018/4/11 20:07
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping("/test")
    public String test(){
        //strRedis.opsForValue().set("stpan","hello world");
        redisOperator.set("q","y");
        return strRedis.opsForValue().get("q");
    }
}
