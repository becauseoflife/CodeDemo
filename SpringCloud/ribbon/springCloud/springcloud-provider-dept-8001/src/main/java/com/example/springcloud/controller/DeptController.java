package com.example.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptService;
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

    // 获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryDept(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }


    // 对注册进来的微服务，获取一些消息
    @RequestMapping("/dept/discovery")
    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery==>service" + services);

        // 得到一个具体的微服务信息,通过一个具体的微服务id applicationName
        List<ServiceInstance> instances = client.getInstances("SPRING-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        }

        return instances;
    }
}
