package com.vily.springcloud.service.impl;

import com.vily.springcloud.dao.PaymentDao;
import com.vily.springcloud.entities.Payment;
import com.vily.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/5
 */
@Service
public class PaymentServiceImpl implements PaymentService {


	@Autowired
	PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
