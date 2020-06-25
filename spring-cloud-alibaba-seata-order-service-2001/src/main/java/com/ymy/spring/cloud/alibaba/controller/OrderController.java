package com.ymy.spring.cloud.alibaba.controller;

import com.ymy.spring.cloud.alibaba.entity.Order;
import com.ymy.spring.cloud.alibaba.entity.SimpleResponse;
import com.ymy.spring.cloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public SimpleResponse create(Order order) {
        int ret = orderService.create(order);
        if (ret > 0) {
            return new SimpleResponse(200, "订单创建成功");
        }
        return new SimpleResponse(444, "订单创建失败");
    }

}
