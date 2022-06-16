package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @desc 在对应的 Mapper类上继承基本的类 BaseMapper<T>
 * @auth llp
 * @date 2022年06月12日 23:28
 */
@Repository // 代表持久层
public interface UserMapper extends BaseMapper<User> {
    // 所有的 CRUD 操作已经编写完成了
    // 你不需要像以前一样配置一大堆文件了
}
