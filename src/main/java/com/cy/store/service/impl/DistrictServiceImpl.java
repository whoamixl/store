package com.cy.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DistrictServiceImpl
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/25 22:06
 * @Version 1.0
 **/
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistrictMapper districtMapper;

    /**
     * @Description:根据父带代号查询其下的区
     * @Author: xiaolong
     * @Date: 2022/1/25 22:07
     * @param parent : 父代号
     * @return: java.util.List<com.cy.store.entity.District>
     **/
    @Override
    public List<Map<String, Object>> getByParent(String parent){
        List<Map<String, Object>> districts = districtMapper.selectMaps(new QueryWrapper<District>()
                .select("code","name")
                .eq("parent", parent)
                .orderByAsc("code"));
        return districts;
    }
    /**
     * @Description:根据code查询名字
     * @Author: xiaolong
     * @Date: 2022/1/25 22:47
     * @param code: 行政code
     * @return: java.lang.String
     **/
    @Override
    public String findByName(String code) {
        String data = districtMapper.findByName(code);
        return data;
    }

}
