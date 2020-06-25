package com.ymy.spring.cloud.alibaba.service.impl;

import com.ymy.spring.cloud.alibaba.mapper.AccountMapper;
import com.ymy.spring.cloud.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int decrease(Integer userId, BigDecimal money) {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accountMapper.decrease(userId, money);
    }
}
