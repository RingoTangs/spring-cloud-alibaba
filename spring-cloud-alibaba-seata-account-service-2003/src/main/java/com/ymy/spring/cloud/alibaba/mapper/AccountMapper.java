package com.ymy.spring.cloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {

    /**
     * 减余额
     */
    public int decrease(@Param("userId") Integer userId, @Param("money") BigDecimal money);
}
