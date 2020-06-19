package com.ymy.spring.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}") // 从配置文件中读取到Provider的微服务名称
    private String serverURL;

    @GetMapping("/consumer")
    public String paymentInfo() {
        return restTemplate.getForObject(serverURL + "/payment/nacos/port", String.class);
    }
}
