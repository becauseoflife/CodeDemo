package com.example.springcloud.service.impl;

import com.example.springcloud.dao.DeptDao;
import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:30
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryDept(Long id) {
        return deptDao.queryDept(id);
    }

    public List<Dept> queryAllDept() {
        return deptDao.queryAllDept();
    }
}
