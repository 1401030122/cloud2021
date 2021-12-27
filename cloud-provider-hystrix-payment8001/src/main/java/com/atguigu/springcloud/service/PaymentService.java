package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 21 17:22
 * @Email 17854262969@163.com
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+"    paymentInfo_ok, id =:  "+id+"\t"+"O(∩_∩)O哈哈~" ;
    }

    // Hystrix服务降级
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(Integer id){
        Integer timeNumber = 2;
//        Integer a=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+"    paymentInfo_TimeOut,id =:  "+id+"\t"+"O(∩_∩)O哈哈~" ;
    }

    public String payment_TimeOutHandler(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+"    8001运行错误或者运行超时,id =:  "+id+"\t"+"o(╥﹏╥)o呜呜呜" ;
    }



    // Hystrix服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled",value = "true"),  //开启闭路器
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"),  //设置请求次数
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //设置重新请求的时间窗口
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60")  //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功,流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallBack(Integer id){
        return "id不能为负数，请稍后再试，o(╥﹏╥)o呜呜呜 ，id="+id;
    }
}

