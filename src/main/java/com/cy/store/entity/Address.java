package com.cy.store.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Address
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/24 22:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName(value = "t_address")
public class Address extends BaseEntity implements Serializable {
    /**
     * 收货地址id
     */
    @TableId(type = IdType.AUTO)
    private Integer aid;

    /**
     * 归属的用户id
     */
    private Integer uid;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 省-名称
     */
    private String provinceName;

    /**
     * 省-行政代号
     */
    private String provinceCode;

    /**
     * 市-名称
     */
    private String cityName;

    /**
     * 市-行政代号
     */
    private String cityCode;

    /**
     * 区-名称
     */
    private String areaName;

    /**
     * 区-行政代号
     */
    private String areaCode;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机
     */
    private String phone;

    /**
     * 固话
     */
    private String tel;

    /**
     * 标签
     */
    private String tag;

    /**
     * 是否默认：0-不默认,1-默认
     */
    private Integer isDefault;
}