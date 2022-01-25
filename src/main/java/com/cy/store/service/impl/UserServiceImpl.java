package com.cy.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务层实现类
 * @Author Yxl
 * @Date 2022/1/20 21:50
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description:注册实现
     * @Author: xiaolong
     * @Date: 2022/1/20 21:50
     * @param user: 用户实体类
     * @return: void
     **/
    @Override
    public void reg(User user) {
        String username = user.getUsername();
        QueryWrapper<User> stringQueryWrapper = new QueryWrapper<>();
        stringQueryWrapper.eq("username",username);
        User user1 = userMapper.selectOne(stringQueryWrapper);
        if (user1 != null){
            throw new UsernameDuplicatedException("用户名已存在！");
        }

        //密码加密处理的实现
        //盐值+password+盐值 md5加密,整体加密3次，很难破解
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();

        String md5Password = getMD5Password(oldPassword, salt);
        //重新设置user对象的密码
        user.setPassword(md5Password);

        //设置用户盐值
        user.setSalt(salt);

        //数据补全 is_delete 设置成0
        user.setIsDelete(0);

        //数据补全 4个日志字段
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());

        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        int insert = userMapper.insert(user);
        if (insert != 1){
            throw new InsertException("在注册过程中产生未知的异常");
        }
    }

    /**
     * @Description:用户登录实现方法
     * @Author: xiaolong
     * @Date: 2022/1/21 22:17
     * @param username: 用户名
     * @param password: 密码
     * @return: com.cy.store.entity.User
     **/
    @Override
    public User login(String username, String password) {
        QueryWrapper<User> selectUser = new QueryWrapper<>();
        selectUser.eq("username",username);
        User user = userMapper.selectOne(selectUser);
        if (user == null){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        String md5Password = getMD5Password(password, user.getSalt());
        if (!user.getPassword().equals(md5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        if (user.getIsDelete() != 0){
            throw new UsernameNotFoundException("用户不存在");
        }

        User user1 = new User();
        user1.setUid(user.getUid());
        user1.setUsername(user.getUsername());
        user1.setAvatar(user.getAvatar());

        return user1;
    }

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
    @Override
    public Integer changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User user = userMapper.selectById(uid);
        if (user == null || user.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户不存在");
        }
        String md5Password = getMD5Password(username, user.getSalt());
        if (!!md5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("原密码密码错误");
        }

        String newMd5Password = getMD5Password(newPassword, user.getSalt());
        user.setPassword(newMd5Password);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        int i = userMapper.updateById(user);
        if (i != 1){
            throw new UpdateException("更新时产生未知的异常");
        }

        return i;
    }

    /**
     * @Description:修改个人资料
     * @Author: xiaolong
     * @Date: 2022/1/22 18:44
     * @param user: 用户实体类
     * @return: java.lang.Integer 是否成功
     **/
    @Override
    public Integer changeInfo(User user) {
        User userUpdate = userMapper.selectById(user.getUid());
        userUpdate.setGender(user.getGender());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setModifiedTime(new Date());
        userUpdate.setModifiedUser(user.getUsername());

        int i = userMapper.updateById(userUpdate);
        if (i != 1){
            throw new UpdateException("更新信息失败");
        }
        return i;
    }


    /**
     * @Description:通过uid查询用户
     * @Author: xiaolong
     * @Date: 2022/1/22 19:14
     * @param uid: 用户id
     * @return: com.cy.store.entity.User 用户实体
     **/
    @Override
    public User getInfo(Integer uid) {
        User user = userMapper.selectById(uid);
        if (user == null || user.getIsDelete() ==1){
            throw new UsernameNotFoundException("用户不存在");
        }
        User result = new User();
        result.setGender(user.getGender());
        result.setEmail(user.getEmail());
        result.setPhone(user.getPhone());
        result.setUsername(user.getUsername());
        return result;
    }

    /**
     * @Description: 修改用户头像
     * @Author: xiaolong
     * @Date: 2022/1/23 10:21
     * @param uid: 用户id
     * @param avatar: 头像路径
     * @param username: 更新人
     * @return: java.lang.Integer
     **/
    @Override
    public Integer changeAvatar(Integer uid, String avatar, String username) {
        User user = userMapper.selectById(uid);
        if (user == null || user.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户未找到");
        }
        user.setAvatar(avatar);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("uid",uid);
        int update = userMapper.update(user, userUpdateWrapper);
        if (update != 1){
            throw new UpdateException("更新时发生异常");
        }
        return update;
    }


    /**
     * @Description:md5算法的加密，密码加密
     * @Author: xiaolong
     * @Date: 2022/1/20 22:28
     * @param password: 密码
     * @param salt: 盐值
     * @return: null
     **/
    private String getMD5Password(String password, String salt){
        //md5加密(进行3次加密)
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
