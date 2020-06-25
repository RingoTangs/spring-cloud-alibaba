package com.ymy.spring.cloud.alibaba;

import com.ymy.spring.cloud.alibaba.mapper.StorageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private StorageMapper storageMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testConnection() throws Exception{
        logger.info("测试连接：" + dataSource.getConnection());
    }

    @Test
    public void testStorageMapperDecrease() {
        int ret = storageMapper.decrease(10, 3);
        logger.info("测试结果： " + ret);
    }

}
