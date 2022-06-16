package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    // 继承了 BaseMapper，所有的方法都来自父类
    // 我们也可以自己扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    // 测试插入
    @Test
    public void testInsert(){
        User user = new User();
        // user.setId(6L);
        user.setName("面包时间插入测试");
        user.setAge(24);
        user.setEmail("843818747@qq.com");

        // 自动生成ID，返回受影响的行数
        int result = userMapper.insert(user);
        System.out.println(result);
        // 发现ID会自动回填
        System.out.println(user);
    }

    // 测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        // 通过条件自动拼接动态SQL
        user.setId(6L);
        user.setName("更新面包");
        user.setAge(20);

        // 注意：updateById 参数是一个对象
        int result = userMapper.updateById(user);
        System.out.println(result);
        // 发现ID会自动回填
        System.out.println(user);
    }

    // 测试乐观锁 成功
    @Test
    public void testVersionSuccess(){
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改信息
        user.setName("面包");
        user.setEmail("843818747@qq.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }

    // 测试乐观锁 失败 多线程下
    @Test
    public void testVersionFail(){
        // 线程1
        User user1 = userMapper.selectById(1L);
        user1.setName("面包11111");
        user1.setEmail("843818747@qq.com");

        // 模拟另一个线程执行插队操作 ======
        User user2 = userMapper.selectById(1L);
        user2.setName("面包22222");
        user2.setEmail("843818747@qq.com");
        userMapper.updateById(user2);
        // =============================
        // 没有乐观锁就会覆盖插队线程的值
        userMapper.updateById(user1);
    }

    // 查询测试
    @Test
    public void testSelect1(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    // 测试批量查询
    @Test
    public void testSelect2(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    // 测试条件查询之一：map
    @Test
    public void testSelect3(){
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询的条件
        map.put("name", "面包");
        map.put("age", 24);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小 size
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println); // 获取分页后的数据
        System.out.println(page.getPages());            // 一共多少页
        System.out.println(page.getTotal());            // 一共多少条记录
        System.out.println(page.getCurrent());          // 当前页
    }

    // 测试删除
    @Test
    public void testDelete(){
        userMapper.deleteById("1536347717583847431");
    }

    // 测试逻辑删除
    @Test
    public void testLogicDelete(){
        userMapper.deleteById(1L);
    }

}
