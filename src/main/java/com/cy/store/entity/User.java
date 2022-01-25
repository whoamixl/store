package com.cy.store.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author Yxl
 * @Date 2022/1/19 22:51
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TableName(value = "t_user")
public class User extends BaseEntity {
    /**
      *用户id
      */
    @TableId(type = IdType.AUTO)
    private Integer uid;

    /**
     *用户用户名
     */
    private String username;

    /**
     *用户密码
     */
    private String password;

    /**
     *用户盐值
     */
    private String salt;

    /**
     *用户手机号
     */
    private  String phone;

    /**
     *用户邮箱
     */
    private String email;

    /**
     *用户性别
     */
    private Integer gender;

    /**
     *用户头像
     */
    private String avatar;

    /**
     *用户是否删除
     */
    private Integer isDelete;
}
