package com.vily.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/18
 */
@Component
public class PaymentFallbackService  implements PaymentHystrixSerice{
    @Override
    public String paymentInfoOK(Integer id) {
        return "服务降级-----------paymentInfoOK";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "服务降级-----------paymentInfoTimeOut";
    }
}
