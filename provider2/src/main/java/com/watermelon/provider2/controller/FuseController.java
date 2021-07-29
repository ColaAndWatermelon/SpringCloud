package com.watermelon.provider2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author watermelon
 * @date 2021/7/29 16:28
 * @descriped 测试sentinel熔断
 */
@RequestMapping("test3")
@RestController
public class FuseController {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 满调用比例
     * */
    @GetMapping("test1")
    public String test1(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test1";
    }

    /**
     * 异常比例
     * */
    @GetMapping("test2")
    public String test2(){
         atomicInteger.getAndIncrement();
         if (atomicInteger.get() % 2 ==0){
             int i = 1/0;
         }
         return "test2";
    }

}
