package com.cy.store.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DistrictServiceTests
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/25 21:58
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private IDistrictService districtService;

    @Test
    public void selectDistrictList(){

        List<Map<String, Object>> districts = districtMapper.selectMaps(new QueryWrapper<District>()
                .select("code","name")
                .eq("parent", "210100")
                .orderByAsc("code"));
        for (Map<String, Object> district : districts) {
            System.out.println(district);
        }
    }

    @Test
    public void findByCode(){
        String byName = districtService.findByName("110108");
        System.out.println(byName);
    }

}
