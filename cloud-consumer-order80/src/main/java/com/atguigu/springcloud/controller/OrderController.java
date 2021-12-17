package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 16 9:41
 * @Email 17854262969@163.com
 */
@RestController
@Slf4j
public class OrderController {

    //    单机配置
//    public static final String PAYMENT_URL = "http://localhost:8001";
//    集群配置：只需要配置服务的名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get")
    public CommonResult<Payment> getById(Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get"+"?id="+id,CommonResult.class);
    }



}
