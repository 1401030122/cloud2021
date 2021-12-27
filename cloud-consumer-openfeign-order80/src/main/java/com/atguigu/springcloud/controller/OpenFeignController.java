package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 21 15:03
 * @Email 17854262969@163.com
 */
@RestController
@Slf4j
public class OpenFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

//    需要在参数中添加@RequestParam对
    @ResponseBody
    @GetMapping(value = "/consumer/payment/get")
    public CommonResult PaymentgetBy(Long id){
        return paymentFeignService.PaymentgetById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String FeignTimeOut(){
//        一般feign的调用时间是1s
        return paymentFeignService.FeignTimeOut();
    }

}
