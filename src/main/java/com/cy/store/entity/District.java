package com.cy.store.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName District
 * @Description 省市区的数据实体类
 * @Author Yxl
 * @Date 2022/1/25 21:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName(value = "t_dict_district")
public class District {
    /**
      *主键id
      */
    private Integer id;
    /**
      *父级编号
      */
    private String parent;
    /**
      * 编号
      */
    private String code;
    /**
      * 名称
      */
    private String name;

}
