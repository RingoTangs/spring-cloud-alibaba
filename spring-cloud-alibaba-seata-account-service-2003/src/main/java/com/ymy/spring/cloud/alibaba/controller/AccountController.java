package com.ymy.spring.cloud.alibaba.controller;

import com.ymy.spring.cloud.alibaba.entity.SimpleResponse;
import com.ymy.spring.cloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public SimpleResponse decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money) {
        int ret = accountService.decrease(userId, money);
        if (ret > 0) {
            return new SimpleResponse(200, "账户扣费成功");
        }
        return new SimpleResponse(444, "账户扣费失败");
    }
}
