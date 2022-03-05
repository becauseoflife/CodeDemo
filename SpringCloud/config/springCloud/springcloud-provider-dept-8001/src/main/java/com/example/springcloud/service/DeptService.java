package com.example.springcloud.service;

import com.example.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:29
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryDept(Long id);

    List<Dept> queryAllDept();
}
