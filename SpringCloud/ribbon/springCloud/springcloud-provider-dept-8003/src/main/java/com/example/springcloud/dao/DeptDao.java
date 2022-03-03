package com.example.springcloud.dao;

import com.example.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:14
 */
@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept queryDept(Long id);

    List<Dept> queryAllDept();
}
