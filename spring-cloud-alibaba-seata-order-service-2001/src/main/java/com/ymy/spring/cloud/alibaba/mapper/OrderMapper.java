package com.ymy.spring.cloud.alibaba.mapper;

import com.ymy.spring.cloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    /**
     * 新建订单
     */
    public int create(Order order);

    /**
     * 修改订单状态
     */
    public int update(@Param("userId") Integer userId, @Param("status") Integer status);

}
