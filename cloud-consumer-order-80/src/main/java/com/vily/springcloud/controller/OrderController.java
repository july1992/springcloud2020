package com.vily.springcloud.controller;

import com.vily.springcloud.entities.CommonResult;
import com.vily.springcloud.entities.Payment;
import com.vily.springcloud.lb.MyLb;
import com.vily.springcloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/6
 */
@RestController
@RequestMapping("order")
@CrossOrigin
@Slf4j
public class OrderController {

    public static String path="http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalance myLb;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        return restTemplate.postForObject(path+"payment/create",payment,CommonResult.class);
    }

//    http://localhost:8082/order/consumer/payment/get/1
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        return restTemplate.getForObject(path+"payment/get/"+id,CommonResult.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(path + "payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){

            return forEntity.getBody();
        }else{
            return new CommonResult(444,"操作失败");
        }
    }

//    http://localhost:8082/order/consumer/lb
    @GetMapping("consumer/lb")
    public String getLb(){


        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() == 0 ){
            return "查询失败";
        }

        ServiceInstance serviceInstance = myLb.instances(instances);

        URI uri = serviceInstance.getUri();

        System.out.println("-----:"+uri+"/payment/lb");
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }


    @GetMapping("consumer/test")
    public String test(){

        return "sadadad";
    }


}
