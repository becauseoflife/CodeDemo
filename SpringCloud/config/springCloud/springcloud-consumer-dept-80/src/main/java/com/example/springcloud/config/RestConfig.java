package com.example.springcloud.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @desc
 * @auth llp
 * @date 2022年02月28日 17:44
 */
@Configuration
public class RestConfig {

    // 负载均衡策略 IRule
    @Bean
    @LoadBalanced       // 配置负载均衡实现 RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
