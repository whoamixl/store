package com.cy.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName DistrictMapper
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/25 21:51
 * @Version 1.0
 **/
@Mapper
public interface DistrictMapper extends BaseMapper<District> {

    @Select("select name from t_dict_district where code=#{code}")
    String findByName(@Param("code") String code);
}
