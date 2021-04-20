package com.vily.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author:vily
 * Date: 2021/4/14
 */
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule(){

        // 随机
        return new RandomRule();
    }
}
