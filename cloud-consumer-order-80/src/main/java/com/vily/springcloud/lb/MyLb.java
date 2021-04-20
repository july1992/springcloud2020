package com.vily.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/17
 */
@Component
public class MyLb implements MyLoadBalance {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    private final int getAndIncrement(){
        int curr;
        int next;
        do{
            curr=this.atomicInteger.get();
            next=curr>=Integer.MAX_VALUE ? 0: curr+1;
        }while (!this.atomicInteger.compareAndSet(curr,next));

        System.out.println("-----:第几次访问next："+next);
        return next;
    };

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
