package com.ymy.spring.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "*********test A*********";
    }

    @GetMapping("/testB")
    public String testB() {
        return "*********test B*********";
    }

    @GetMapping("/testD")
    public String testD() {
        int age = 10 / 0;
        return "*********test D*********";
    }

    /**
     * 热点参数限流业务代码
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testHotKeyHandler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "*********testHotKey*********";
    }

    /**
     * 热点参数兜底方法
     */
    public String testHotKeyHandler(String p1, String p2, BlockException e) {
        return "*********testHotKeyHandler o(╥﹏╥)o*********";
    }
}
