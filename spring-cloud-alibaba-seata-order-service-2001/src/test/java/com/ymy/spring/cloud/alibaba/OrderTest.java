package com.ymy.spring.cloud.alibaba;

import com.ymy.spring.cloud.alibaba.entity.Order;
import com.ymy.spring.cloud.alibaba.mapper.OrderMapper;
import io.seata.rm.datasource.DataSourceProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private OrderMapper orderMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 测试本模块是否能成功连接到数据库
     */
    @Test
    public void testConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        logger.info("测试本模块连接到数据库 " + connection);
    }

    /**
     * 测试创建订单
     */
    @Test
    public void testOrderMapperCreate() {
        int ret = orderMapper.create(new Order(2, 2, 32, new BigDecimal(10)));
        logger.info("数据插入结果：" + ret);
    }

    /**
     * 测试修改订单状态
     */
    @Test
    public void testOrderMapperUpdate() {
        int ret = orderMapper.update(1, 0);
        logger.info("订单状态修改结果：" + ret);
    }

}
