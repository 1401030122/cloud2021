package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 15 17:16
 * @Email 17854262969@163.com
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result =  paymentService.create(payment);
        log.info("********插入结果为："+result);
        Integer a =10;
        if(result>0){
            return new CommonResult(200,"插入数据库成功,端口号为："+serverPort,result);
        }else {
            return  new CommonResult(444,"插入数据失败",null);
        }
    }

    @ResponseBody
    @GetMapping(value = "/payment/get")
    public CommonResult PaymentgetById(Long id){
        Payment payment=  null!=paymentService.getPaymentById(id)?paymentService.getPaymentById(id):null;
        log.info("********得到结果为：" +payment);
        if(null!= payment){
            return new CommonResult(200,"查询数据成功,端口号为："+serverPort,payment);
        }else {
            return  new CommonResult(444,"查询数据失败",null);
        }
    }
}
