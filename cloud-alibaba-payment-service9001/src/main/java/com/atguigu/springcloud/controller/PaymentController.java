package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 24 14:22
 * @Email 17854262969@163.com
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String testPayment(@PathVariable("id") Integer id){
        return "nacos registry, serverport :"+ serverPort +"\t id"+id;
    }
}
