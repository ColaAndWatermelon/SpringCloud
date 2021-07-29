package com.watermelon.provider2.component;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.http.param.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author Aiden Yan
 * @date 2021-07-27
 * @descriped
 */
@Slf4j
@Component
public class MyExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.info("BlockExceptionHandler BlockException================"+e.getRule());
        JSONObject jsonObject = new JSONObject();
        if (e instanceof FlowException){
            jsonObject.put("code", "100");
            jsonObject.put("msg", "限流");
        }else if (e instanceof DegradeException){
            jsonObject.put("code", "101");
            jsonObject.put("msg", "服务降级");
        }else if (e instanceof ParamFlowException){
            jsonObject.put("code", "102");
            jsonObject.put("msg", "热点参数限流");
        }else if (e instanceof SystemBlockException){
            jsonObject.put("code", "103");
            jsonObject.put("msg", "触发系统保护规则");
        }else if (e instanceof AuthorityException){
            jsonObject.put("code", "104");
            jsonObject.put("msg", "授权规则不通过");
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(),jsonObject);
    }
}
