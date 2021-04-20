package com.vily.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Description: 手写算法
 * Author:vily
 * Date: 2021/4/17
 */
public interface MyLoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
