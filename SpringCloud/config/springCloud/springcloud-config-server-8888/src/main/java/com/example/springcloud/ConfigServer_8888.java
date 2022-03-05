package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @desc
 * @auth llp
 * @date 2022年03月05日 19:39
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer_8888 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_8888.class, args);
    }
}
