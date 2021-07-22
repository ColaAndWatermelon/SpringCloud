package com.watermelon.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Aiden Yan
 * @date 2021-07-22
 * @descriped
 */
@FeignClient(name = "provider")
public interface ProviderFeign {

    @GetMapping("/sayHello")
    String sayHello();

}
