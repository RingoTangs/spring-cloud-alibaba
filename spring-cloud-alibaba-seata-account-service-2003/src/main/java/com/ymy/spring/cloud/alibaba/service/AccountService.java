package com.ymy.spring.cloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {

    public int decrease(Integer userId, BigDecimal money);

}
