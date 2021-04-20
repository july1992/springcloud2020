package com.vily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @className: ConfigServerApplication3344
 * @description:
 * @author: zmm
 * @create: 2020-06-09 11:20
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3344.class,args);
    }
}
