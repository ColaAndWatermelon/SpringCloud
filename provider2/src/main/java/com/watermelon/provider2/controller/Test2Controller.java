package com.watermelon.provider2.controller;

import com.watermelon.provider2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author watermelon
 * @date 2021/7/20 20:46
 */
@RestController
@RequestMapping("test2")
public class Test2Controller {

    @Autowired
    private TestService testService;

    @GetMapping("sayHello/{param}")
    public String sayHello(@PathVariable("param") Integer param){
        return testService.returnByParam(param);
    }

    @GetMapping("sayHello2/{param}")
    public String sayHello2(@PathVariable("param") Integer param){
        return testService.returnByParam(param);
    }

}
