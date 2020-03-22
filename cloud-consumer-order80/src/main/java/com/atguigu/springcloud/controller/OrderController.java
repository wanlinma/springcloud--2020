package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    private static final String INVOKE_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> paymentInfo(@RequestBody Payment payment){
        return restTemplate.postForObject(INVOKE_URL + "/payment/create", payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentInfo(@PathVariable Integer id){
        return restTemplate.getForObject(INVOKE_URL+"/payment/get/"+id,CommonResult.class);
    }

}
