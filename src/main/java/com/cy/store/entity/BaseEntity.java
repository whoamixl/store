package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Description 实体类的基类
 * @Author Yxl
 * @Date 2022/1/19 22:44
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity implements Serializable {
    /**
      *创建人
      */
    private String createdUser;

    /**
      *创建时间
      */
    private Date createdTime;

    /**
      *修改人
      */
    private String modifiedUser;

    /**
      *修改时间
      */
    private Date modifiedTime;
}
