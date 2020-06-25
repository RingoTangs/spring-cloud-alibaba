package com.ymy.spring.cloud.alibaba.service;

import com.ymy.spring.cloud.alibaba.entity.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    public int create(Order order);

}
