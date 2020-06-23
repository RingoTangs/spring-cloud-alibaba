package com.ymy.spring.cloud.alibaba.service;

import com.ymy.spring.cloud.alibaba.service.impl.FeignServiceFallback;
import com.ymy.spring.cloud.entity.Payment;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-alibaba-provider", fallback = FeignServiceFallback.class)
public interface FeignService {

    // 直接复制Provider的方法即可
    @GetMapping("/payment/{id}")
    public SimpleResponse<Payment> payment(@PathVariable("id") String id);
}
