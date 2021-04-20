package com.vily.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/17
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixSerice {


    @GetMapping("payment/histrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id);


    @GetMapping("payment/histrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
