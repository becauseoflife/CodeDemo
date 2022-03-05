package com.exmaple.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @desc 启动后访问地址：http://localhost:7003/
 * @auth llp
 * @date 2022年03月01日 10:44
 */
@SpringBootApplication
@EnableEurekaServer // EnableEurekaServer 服务端的启动类，可以接受别人注册进来（核心注解）
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }
}
