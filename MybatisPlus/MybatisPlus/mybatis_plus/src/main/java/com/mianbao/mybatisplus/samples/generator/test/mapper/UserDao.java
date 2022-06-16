package com.mianbao.mybatisplus.samples.generator.test.mapper;

import com.mianbao.mybatisplus.samples.generator.test.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 面包
 * @since 2022-06-16
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
