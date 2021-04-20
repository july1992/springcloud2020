package com.vily.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description:RestTemplate 用来链接远程主机
 * LoadBalanced 当有多个主机当时候，必须开启 用来负载均衡
 * LoadBalanced 默认是轮询  SpringBootApplication里面有个ComponentScan会扫描application当前包下的所有文件
 * 但是自定义轮询规则的话，要避开被扫描到，所以到com.vily.rule下新建类
 * Author:vily
 * Date: 2021/4/6
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
