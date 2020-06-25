package com.ymy.spring.cloud.alibaba.service;

import com.ymy.spring.cloud.alibaba.entity.SimpleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "cloud-alibaba-seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    public SimpleResponse decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
