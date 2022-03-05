package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @desc
 * @auth llp
 * @date 2022年02月28日 18:03
 */
@SpringBootApplication
@EnableEurekaClient
// @LoadBalancerClient(name = "SPRING-PROVIDER-DEPT", configuration = MyLoadBalance.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
