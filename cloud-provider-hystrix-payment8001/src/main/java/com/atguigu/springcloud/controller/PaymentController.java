package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 21 17:31
 * @Email 17854262969@163.com
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_ok(id);
        log.info("****result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeOut(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("****result"+result);
        return result;
    }


//    设置服务熔断的接口
    @GetMapping("/payment/circuit/{id}")
    public String paymentInfo_Breaker(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result"+result);
        return result;
    }


}
