package com.vily.springcloud.service;

import com.vily.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/5
 */
public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(@Param("id")Long id);

}
