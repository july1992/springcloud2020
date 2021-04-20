package com.vily.springcloud.control;

import com.vily.springcloud.entities.CommonResult;
import com.vily.springcloud.entities.Payment;
import com.vily.springcloud.service.PaymentService;
import com.vily.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/5
 */

@RestController
@RequestMapping("payment")
@CrossOrigin
public class PaymentController {


	@Autowired
	private PaymentServiceImpl paymentService;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping("create")
	public CommonResult create(@RequestBody Payment payment){

		int i = paymentService.create(payment);

		if(i>0){
			return new CommonResult(200,"插入成功:server.port:"+serverPort);
		}else{
			return new CommonResult(444,"插入失败");
		}

	}


	@GetMapping("get/{id}")
	public CommonResult getPaymentById(@PathVariable("id")Long id){

		Payment payment = paymentService.getPaymentById(id);

		if (payment != null){
			CommonResult commonResult = new CommonResult(200, "查询成功,端口号:"+serverPort, payment);
			return commonResult;
		}else {
			return new CommonResult(444,"数据不存在",null);
		}

	}

	@GetMapping("test")
	public CommonResult test(){

		return new CommonResult(202,"测试成功");
	}
	@GetMapping("lb")
	public String getServerPort(){
		return serverPort;
	}
}
