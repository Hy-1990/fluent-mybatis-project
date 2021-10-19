package com.hy.fmp.fluent.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * TestFluentMybatisEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "test_fluent_mybatis",
    schema = "vpp"
)
public class TestFluentMybatisEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 自增主键
   */
  @TableId("id")
  private Integer id;

  /**
   * 年龄
   */
  @TableField("age")
  private Integer age;

  /**
   * 创建时间
   */
  @TableField("create_time")
  private Date createTime;

  /**
   * 是否删除
   */
  @TableField("del_flag")
  private Integer delFlag;

  /**
   * 姓名
   */
  @TableField("name")
  private String name;

  @Override
  public final Class entityClass() {
    return TestFluentMybatisEntity.class;
  }
}
