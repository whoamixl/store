package com.cy.store.controller;

import com.cy.store.service.IDistrictService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DistrictController
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/25 22:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;

    @PostMapping({"/",""})
    public JsonResult<List<Map<String,Object>>> getByParent(String parent){
        List<Map<String, Object>> data = districtService.getByParent(parent);
        return new JsonResult<>(OK,"获取成功",data);
    }
}
