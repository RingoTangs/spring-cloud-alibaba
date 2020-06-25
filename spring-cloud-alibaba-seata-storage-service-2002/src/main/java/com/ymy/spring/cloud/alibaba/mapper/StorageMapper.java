package com.ymy.spring.cloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    /**
     * 减库存
     */
    public int decrease(@Param("productId") Integer productId, @Param("count") Integer count);
}
