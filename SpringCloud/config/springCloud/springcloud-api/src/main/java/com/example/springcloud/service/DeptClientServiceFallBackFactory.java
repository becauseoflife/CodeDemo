package com.example.springcloud.service;

import com.example.springcloud.pojo.Dept;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc 降级
 * @auth llp
 * @date 2022年03月03日 17:03
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            public boolean addDept(Dept dept) {
                return false;
            }

            public Dept queryDept(Long id) {
                return new Dept()
                        .setDeptNo(id)
                        .setDeptName("id=>" + id + "没有对应的信息。客户端提供了降级信息，这个服务已经被关闭！")
                        .setDbSource("no this Database in MySQL");
            }

            public List<Dept> queryAllDept() {
                return null;
            }
        };
    }
}
