package com.watermelon.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author watermelon
 * @date 2020/10/7 20:34
 */
@RestController
public class SaveController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @GetMapping("save/{message}")
    public String save(@PathVariable("message") String message) {
        redisTemplate.opsForValue().set(message, message);
        return "success";
    }
}
