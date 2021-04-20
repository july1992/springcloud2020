package com.vily.spiringcloud.controller;

import com.vily.spiringcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/17
 */
@RestController
@RequestMapping("payment")
@CrossOrigin
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("histrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfoOK(id);
        return s;
    }

    @GetMapping("histrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){

        return paymentService.paymentInfoTimeOut(id);
    }


    //====服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
