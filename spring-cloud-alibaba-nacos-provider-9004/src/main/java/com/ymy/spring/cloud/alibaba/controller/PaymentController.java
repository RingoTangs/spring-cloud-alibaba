package com.ymy.spring.cloud.alibaba.controller;

import com.ymy.spring.cloud.entity.Payment;
import com.ymy.spring.cloud.entity.SimpleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public SimpleResponse<Payment> payment(@PathVariable("id") String id) {
        return new SimpleResponse<Payment>(200, "ok " + port, new Payment(id, "serial" + id));
    }
}
