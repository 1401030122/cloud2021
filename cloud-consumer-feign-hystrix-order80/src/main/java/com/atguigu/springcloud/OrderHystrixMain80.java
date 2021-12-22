package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 22 9:13
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //激活Hystrix
//@EnableCircuitBreaker
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
