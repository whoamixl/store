package com.cy.store.service;

import com.alibaba.fastjson.JSON;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.parser.Entity;
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
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuanxin02");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User test01 = userService.login("test01", "123456");
        System.out.println(test01);
    }

    @Test
    public void changePassword(){
        Integer test01 = userService.changePassword(6, "test01", "123456", "123");
        System.out.println(test01);
    }

    @Test
    public void changeAvatar(){
        Integer update = userService.changeAvatar(14, "/data/1.png", "小明");
        System.out.println(update);

    }

    @Test
    public void toolsTest(){

    }
}
