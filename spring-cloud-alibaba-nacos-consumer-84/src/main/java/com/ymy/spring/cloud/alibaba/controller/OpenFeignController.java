package com.ymy.spring.cloud.alibaba.controller;

import com.ymy.spring.cloud.alibaba.service.FeignService;
import com.ymy.spring.cloud.entity.Payment;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OpenFeignController {

    @Resource
    private FeignService feignService;

    @GetMapping("/openFeign/consumer/{id}")
    public SimpleResponse<Payment> consumer(@PathVariable("id") String id) {
        SimpleResponse<Payment> ret = feignService.payment(id);
        return ret;
    }
}
