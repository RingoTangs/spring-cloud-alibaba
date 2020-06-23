package com.ymy.spring.cloud.alibaba.service.impl;

import com.ymy.spring.cloud.alibaba.service.FeignService;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public SimpleResponse payment(String id) {
        return new SimpleResponse(444444, "openFeign fallback");
    }
}
