package com.ymy.spring.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ymy.spring.cloud.entity.Payment;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/{id}")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackHandler")
    public SimpleResponse<Payment> consumer(@PathVariable("id") String id) {
        SimpleResponse<Payment> ret = restTemplate.getForObject(url + "/payment/" + id, SimpleResponse.class);
        if ("4".equals(id)) {
            throw new IllegalArgumentException("非法参数异常" + id);
        } else if (ret.getData() == null) {
            throw new NullPointerException("空指针异常");
        }
        return ret;
    }

    // 兜底SentinelDashboard配置处理方法
    public SimpleResponse blockHandler(@PathVariable("id") String id, BlockException e) {
        return new SimpleResponse(445, "限流 " + id);
    }

    //兜底异常处理方法
    public SimpleResponse fallbackHandler(@PathVariable("id") String id, Throwable t) {
        Payment payment = new Payment(id, null);
        return new SimpleResponse<>(444, "异常处理" + t.getMessage(), payment);
    }
}
