package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 21 14:47
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
