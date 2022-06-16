package com.mianbao.mybatisplus.samples.generator.test.service.impl;

import com.mianbao.mybatisplus.samples.generator.test.entity.UserEntity;
import com.mianbao.mybatisplus.samples.generator.test.mapper.UserDao;
import com.mianbao.mybatisplus.samples.generator.test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 面包
 * @since 2022-06-16
 */
@Service
public class UserServiceImp extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
