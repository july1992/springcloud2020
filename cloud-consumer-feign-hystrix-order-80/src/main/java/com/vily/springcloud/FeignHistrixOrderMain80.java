package com.vily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/6
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class FeignHistrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHistrixOrderMain80.class,args);
    }
}
