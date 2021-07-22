package com.watermelon.consumer.controller;

import com.watermelon.consumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author watermelon
 * @date 2021/7/20 20:42
 */
@RestController
public class TestController {

    private static final String url = "/provider";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("test")
    public String test(){
        String forObject = restTemplate.getForObject("http://provider/provider/sayHello", String.class);
        return forObject;
    }

    @GetMapping("test2")
    public String test2(){
        String forObject = providerFeign.sayHello();
        return forObject;
    }



}
