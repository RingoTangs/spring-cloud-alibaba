package com.ymy.spring.cloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ymy.spring.cloud.entity.SimpleResponse;

public class CustomerBlockHandler {
    /**
     * 全局兜底方案
     * 这里一定要static
     */
    public static SimpleResponse handlerException(BlockException e) {
        return new SimpleResponse(444, "按用户自定义,全局兜底方案");
    }
}
