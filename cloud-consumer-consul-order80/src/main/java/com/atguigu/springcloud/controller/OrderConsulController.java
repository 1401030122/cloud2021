package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 20 15:32
 * @Email 17854262969@163.com
 */
@RestController
@Slf4j
public class OrderConsulController {
    //    单机配置
//    public static final String PAYMENT_URL = "http://localhost:8001";
//    集群配置：只需要配置服务的名称
    public static final String PAYMENT_URL = "http://cloud-provider-consul-payment";
    @Resource
    private RestTemplate restTemplate;


    @ResponseBody
    @GetMapping(value = "/consumer/payment/consul")
    public String getById(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
        return result;
    }

}
