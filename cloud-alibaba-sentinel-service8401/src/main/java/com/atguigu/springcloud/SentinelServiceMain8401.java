package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 27 10:31
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
        public static void main(String[] args) {
                SpringApplication.run(SentinelServiceMain8401.class,args);
            }
}
