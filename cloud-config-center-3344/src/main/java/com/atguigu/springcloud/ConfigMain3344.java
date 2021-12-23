package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 23 14:14
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigMain3344 {
        public static void main(String[] args) {
                SpringApplication.run(ConfigMain3344.class,args);
            }
}
