package com.ymy.spring.cloud.alibaba.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ymy.spring.cloud.alibaba.mapper")
public class MyBatisConf {
}
