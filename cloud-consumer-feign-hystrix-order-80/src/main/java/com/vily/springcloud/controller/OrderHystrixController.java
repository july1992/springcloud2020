package com.vily.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.vily.springcloud.service.PaymentHystrixSerice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/17
 */
@RestController
@CrossOrigin
@RequestMapping("order")
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    PaymentHystrixSerice paymentHystrixSerice;

    @GetMapping("consumer/payment/histrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        String s = paymentHystrixSerice.paymentInfoOK(id);
        return s;
    }

    @GetMapping("consumer/payment/histrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000")
//    })
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){

//        int a=10/0;
        return paymentHystrixSerice.paymentInfoTimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
