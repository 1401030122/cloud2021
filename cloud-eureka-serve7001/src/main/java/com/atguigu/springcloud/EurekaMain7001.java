package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 16 14:21
 * @Email 17854262969@163.com
 */
@SpringBootApplication
public class EurekaMain7001 {
    public static void main(String[] args){
        SpringApplication.run(EurekaMain7001.class,args);
    }
}

