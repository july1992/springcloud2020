package com.vily.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ConfigClientController
 * @description:
 * @author: zmm
 * @create: 2020-06-09 12:21
 */

@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    //http://localhost:3355/configInfo
    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo+",serverPort = "+serverPort;
    }

    // 每次在运维在git上更改配置后都需要请求post接口主动刷新3355客户端
//    curl -X POST "http://localhost:3355/actuator/refresh"
}
