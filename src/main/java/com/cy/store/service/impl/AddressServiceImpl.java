package com.cy.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.ex.AddressCountLimitException;
import com.cy.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/24 23:04
 * @Version 1.0
 **/

@Service
public class AddressServiceImpl implements IAddressService {

    @Value("${user.address.max-count}")
    private Integer USER_ADDRESS_MAX_COUNT;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    /**
     * @Description:添加收货地址
     * @Author: xiaolong
     * @Date: 2022/1/24 23:18
     * @param uid: 登录用户id
     * @param username: 登录的用户
     * @param address: address实体类
     * @return: void
     **/
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        QueryWrapper<Address> integerQueryWrapper = new QueryWrapper<>();
        integerQueryWrapper.eq("uid",uid);
        Long count = addressMapper.selectCount(integerQueryWrapper);
        if (count >= USER_ADDRESS_MAX_COUNT){
            throw new AddressCountLimitException("用户收货地址超出限制");
        }

        String provinceName = districtService.findByName(address.getProvinceCode());
        String cityName = districtService.findByName(address.getCityCode());
        String areaName = districtService.findByName(address.getAreaCode());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);


        Integer isDefault = count == 0 ? 1 : 0;

        address.setUid(uid);
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setIsDefault(isDefault);

        int insert = addressMapper.insert(address);
        if (insert != 1){
            throw new InsertException("添加收货地址时发生异常");
        }
    }
}
