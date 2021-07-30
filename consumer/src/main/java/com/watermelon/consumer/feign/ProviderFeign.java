package com.watermelon.consumer.feign;

import com.watermelon.consumer.feign.fallback.ProviderFeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Aiden Yan
 * @date 2021-07-22
 * @descriped
 */
@FeignClient(name = "provider", fallback = ProviderFeignService.class)
public interface ProviderFeign {

    @GetMapping("/test3/test2")
    String sayHello();

}
