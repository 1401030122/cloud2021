package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 24 14:20
 * @Email 17854262969@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {
        public static void main(String[] args) {
                SpringApplication.run(NacosProviderMain9002.class,args);
            }

}
