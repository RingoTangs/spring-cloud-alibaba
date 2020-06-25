package com.ymy.spring.cloud.alibaba.service.impl;

import com.ymy.spring.cloud.alibaba.entity.Order;
import com.ymy.spring.cloud.alibaba.mapper.OrderMapper;
import com.ymy.spring.cloud.alibaba.service.AccountService;
import com.ymy.spring.cloud.alibaba.service.OrderService;
import com.ymy.spring.cloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @GlobalTransactional(name = "fsp_tx_group", rollbackFor = Exception.class)
    public int create(Order order) {
        logger.info("*********开始新建订单*********");
        orderMapper.create(order);

        logger.info("*********订单微服务调用，减库存*********");
        storageService.decrease(order.getProductId(), order.getCount());

        logger.info("*********账户余额微服务调用，减余额*********");
        accountService.decrease(order.getUserId(), order.getMoney());

        logger.info("*********修改订单状态从0到1*********");
        int ret = orderMapper.update(order.getUserId(), 1);

        logger.info("*********订单创建完成*********");
        return ret;
    }

}
