package com.vily.springcloud.dao;

import com.vily.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/4
 */
@Mapper
public interface PaymentDao {

	 int create(Payment payment);

	 Payment getPaymentById(@Param("id")Long id);
}
