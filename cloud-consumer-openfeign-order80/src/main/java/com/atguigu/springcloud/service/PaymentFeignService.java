package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @Author   ZhaoJie
 *  @Version  1.0
 *  @Data     2021/12/21 14:58
 *  @Email    17854262969@163.com
 *  @Description  使用openfeign实现对服务端接口的调用
*/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
//    需要添加@RequestParam 对参数进行校正
    @ResponseBody
    @GetMapping(value = "/payment/get")
    public CommonResult PaymentgetById(@RequestParam("id")Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String FeignTimeOut();

}
