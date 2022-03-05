package com.example.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提供 restful 接口
 * @author llp
 * @date 2022年02月28日 15:41
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryDept(id);

        if (dept == null){
            throw new RuntimeException("id=>" + id + "不存在该用户或者找不到信息！");
        }
        return dept;
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptNo(id)
                .setDeptName("id=>" + id + "没有对应的信息：null--@Hystrix！")
                .setDbSource("no this Database in MySQL");
    }

}
