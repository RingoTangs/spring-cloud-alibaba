package com.ymy.spring.cloud.alibaba.service;

import com.ymy.spring.cloud.alibaba.entity.SimpleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-alibaba-seata-storage-service")
public interface StorageService {

    /**
     * 対库存的扣减
     */
    @PostMapping("/storage/decrease")
    public SimpleResponse decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
