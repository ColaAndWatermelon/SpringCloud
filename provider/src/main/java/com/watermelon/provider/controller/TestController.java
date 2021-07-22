package com.watermelon.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author watermelon
 * @date 2021/7/20 20:46
 */
@RestController
public class TestController {

    @GetMapping("sayHello")
    public String sayHello(){
        System.out.println("hello world");
        return "hello world";
    }

}
