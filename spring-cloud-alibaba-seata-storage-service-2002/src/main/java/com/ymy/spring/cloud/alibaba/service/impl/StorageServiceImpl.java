package com.ymy.spring.cloud.alibaba.service.impl;

import com.ymy.spring.cloud.alibaba.mapper.StorageMapper;
import com.ymy.spring.cloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public int decrease(Integer productId, Integer count) {
        return storageMapper.decrease(productId, count);
    }
}
