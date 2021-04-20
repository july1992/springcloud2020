package com.vily.springcloud.controll;

import com.vily.springcloud.entities.CommonResult;
import com.vily.springcloud.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/17
 */
@RestController
@RequestMapping("order")
@CrossOrigin
@Slf4j
public class OrderController {
    @Autowired
    private FeignPaymentService feignPaymentService;

    //http://localhost:8083/order/consumer/payment/get/1
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        System.out.println("发起请求：");

        return feignPaymentService.getPaymentById(id);
    }

    //http://localhost/order/consumer/payment/openfeign/timeout
    @GetMapping("consumer/payment/openfeign/timeout")
    public String openFeignTimeout(){

        System.out.println("发起请求：");

        return feignPaymentService.openFeignTimeout();
    }
}
