package com.watermelon.provider2.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author watermelon
 * @date 2021/7/25 15:04
 */
@Service
public class TestService {

    @SentinelResource("test")
    public String returnByParam(Integer param){
        if (param == 1){
            return "1";
        }else {
            return "2";
        }
    }

}
