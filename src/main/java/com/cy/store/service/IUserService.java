package com.cy.store.service;

import com.cy.store.entity.User;

import java.util.Date;

/**
 * @ClassName IUserService
 * @Description 用户业务接口
 * @Author Yxl
 * @Date 2022/1/20 21:48
 * @Version 1.0
 **/
public interface IUserService {
    /**
     * @Description:用户注册方法
     * @Author: xiaolong
     * @Date: 2022/1/20 21:49
     * @param user: 用户数据对象
     * @return: void
     **/
    void reg(User user);

    /**
     * @Description: 登录功能
     * @Author: xiaolong
     * @Date: 2022/1/21 21:51
     * @param username: 用户名
     * @param password: 用户的密码
     * @return: com.cy.store.entity.User
     **/
    User login(String username,String password);

    /**
     * @Description: 根据uid更新密码
     * @Author: xiaolong
     * @Date: 2022/1/22 17:36
     * @param uid: 用户主键
     * @param username: 用户名
     * @param oldPassword: 旧密码
     * @param newPassword: 新密码
     * @return: java.lang.Integer 受影响的行数
     **/
    Integer changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * @Description:修改个人资料
     * @Author: xiaolong
     * @Date: 2022/1/22 18:44
     * @param user: 用户实体类
     * @return: java.lang.Integer 是否成功
     **/
    Integer changeInfo(User user);

    /**
     * @Description:通过uid查询用户
     * @Author: xiaolong
     * @Date: 2022/1/22 19:14
     * @param uid: 用户id
     * @return: com.cy.store.entity.User 用户实体
     **/
    User getInfo(Integer uid);

    /**
     * @Description: 修改用户头像
     * @Author: xiaolong 
     * @Date: 2022/1/23 10:21
     * @param uid: 用户id
     * @param avatar: 头像路径
     * @param username: 更新人
     * @return: java.lang.Integer
     **/
    Integer changeAvatar(Integer uid, String avatar,String username);
}
