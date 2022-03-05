package com.example.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept 实体类
 * @author llp
 * @date 2022年01月08日 15:19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  // 链式写法
public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;

    // 看一下这个数据是存在哪个数据库中的字段
    // 微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库中
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
