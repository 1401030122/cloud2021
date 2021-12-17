package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 16 9:46
 * @Email 17854262969@163.com
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 对消费端进行负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
