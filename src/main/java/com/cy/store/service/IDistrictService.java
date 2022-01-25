package com.cy.store.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IDistrictService
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/25 22:06
 * @Version 1.0
 **/
public interface IDistrictService {
    /**
     * @Description:根据父带代号查询其下的区
     * @Author: xiaolong
     * @Date: 2022/1/25 22:07
     * @param parent : 父代号
     * @return: java.util.List<com.cy.store.entity.District>
     **/
    List<Map<String, Object>> getByParent(String parent);

    /**
     * @Description:根据code查询名字
     * @Author: xiaolong
     * @Date: 2022/1/25 22:47
     * @param code: 行政code
     * @return: java.lang.String
     **/
    String findByName(String code);
}
