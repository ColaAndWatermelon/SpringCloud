package com.watermelon.consumer.feign.fallback;

import com.watermelon.consumer.feign.ProviderFeign;
import org.springframework.stereotype.Component;

/**
 * @author watermelon
 * @date 2021/7/29 22:57
 */
@Component
public class ProviderFeignService implements ProviderFeign {

    @Override
    public String sayHello() {
        return "OpenFeign fallback";
    }

}
