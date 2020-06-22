package com.ymy.spring.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ymy.spring.cloud.alibaba.handler.CustomerBlockHandler;
import com.ymy.spring.cloud.entity.Payment;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResourceHandler")
    public SimpleResponse byResource() {
        return new SimpleResponse(200, "按资源名称限流OK！", new Payment("1", "serial01"));
    }

    /**
     * 这个就是兜底方法
     */
    public SimpleResponse byResourceHandler(BlockException e) {
        return new SimpleResponse(444, e.getClass().getName() + "\t 服务不可用！");
    }

    /**
     * 没有兜底方法 将采用系统默认的
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public SimpleResponse byUrl() {
        return new SimpleResponse(200, "按url限流OK！", new Payment("2", "serial02"));
    }

    /**
     * 用户自定义限流处理逻辑
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public SimpleResponse customerBlockHandler() {
        return new SimpleResponse(200, "按用户自定义限流OK！", new Payment("3", "serial03"));
    }
}
