package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myHandler.Customerhandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhaoJie
 * @Version 1.0
 * @Data 27 10:38
 * @Email 17854262969@163.com
 */
@RestController
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        return "-------testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "-------testB";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",
            blockHandlerClass = Customerhandler.class,
            blockHandler = "handlerException2")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }


//    测试sentinel持久化层的配置
    @GetMapping(value = "/testC")
    public String testC(){
        return "-------testC";
    }

}
