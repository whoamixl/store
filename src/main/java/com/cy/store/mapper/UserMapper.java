package com.cy.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/19 23:00
 * @Version 1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
