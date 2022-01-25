package com.cy.store.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Description 测试类
 * @Author Yxl
 * @Date 2022/1/19 23:14
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class) // Runwith标识启动这个单元测试类（单元测试类是不能够被启动的） 需要传递一个参数必须是SpringRunner的实例类型
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void selectByUsername(){
        HashMap<String, Object> selectMap = new HashMap<>();
        selectMap.put("username","tim");
        List<User> users = userMapper.selectByMap(selectMap);
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    public void selectByUid(){
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        User user = new User();
        user.setUid(3);
        user.setPassword("321");
        user.setModifiedUser("管理员");
        user.setModifiedTime(new Date());
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void updataInfo(){
        User user = new User();
        user.setUid(6);
        user.setPhone("123123123");
        user.setModifiedUser("zzz");
        user.setModifiedTime(new Date());
        user.setEmail("123123@qq.com");
        user.setGender(1);
        userMapper.updateById(user);
    }

    @Test
    public void updateAvatar(){
        User user = new User();
        user.setAvatar("zzz");
        UpdateWrapper<User> objectUpdateWrapper = new UpdateWrapper<>();
        objectUpdateWrapper.eq("uid",14);
        int update = userMapper.update(user, objectUpdateWrapper);
        System.out.println(update);

    }
}
