package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 17 11:53
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {
    public static void main(String[] args){
        SpringApplication.run(Payment8002.class,args);
    }
}
