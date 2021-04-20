package com.vily.springcloud.control;

import com.oracle.tools.packager.Log;
import com.vily.springcloud.entities.CommonResult;
import com.vily.springcloud.entities.Payment;
import com.vily.springcloud.service.PaymentService;
import com.vily.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private PaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("create")
	public CommonResult create(@RequestBody Payment payment){

		int i = paymentService.create(payment);

		if(i>0){
			return new CommonResult(200,"插入成功: server.port:"+serverPort);
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

	@GetMapping("discovery")
	public Object discovery(){

		List<String> services = discoveryClient.getServices();
		services.forEach(data -> Log.info("-----:"+data));

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

		instances.forEach(data -> {
			Log.info("----:"+data.getServiceId()+"--:"+data.getHost()+"----:"+
					data.getPort()+"-----:"+data.getUri());
		});

		return discoveryClient;

	}

	@GetMapping("lb")
	public String getServerPort(){
		return serverPort;
	}


	@GetMapping("openfeign/timeout")
	public String openFeignTimeout(){
		System.out.println("openfeign 超时测试");
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch (Exception e){

		}

		return serverPort;
	}

	//http://localhost:8001/payment/zipkin

}
