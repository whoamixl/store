package com.cy.store.service;

import com.cy.store.entity.Address;

/**
 * @ClassName IAddressService
 * @Description 收获地址业务接口层
 * @Author Yxl
 * @Date 2022/1/24 22:57
 * @Version 1.0
 **/
public interface IAddressService {
    /**
     * @Description:添加收货地址
     * @Author: xiaolong
     * @Date: 2022/1/24 23:18
     * @param uid: 登录用户id
     * @param username: 登录的用户
     * @param address: address实体类
     * @return: void
     **/
    void addNewAddress(Integer uid, String username, Address address);
}
