package com.ymy.spring.cloud.alibaba.controller;

import com.ymy.spring.cloud.alibaba.entity.SimpleResponse;
import com.ymy.spring.cloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public SimpleResponse decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        int ret = storageService.decrease(productId, count);
        if (ret > 0) {
            return new SimpleResponse(200, "库存修改成功");
        }
        return new SimpleResponse(444, "库存修改失败");
    }
}
