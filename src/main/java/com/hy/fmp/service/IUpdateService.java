package com.hy.fmp.service;

import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;

/** @Author huyi @Date 2021/11/22 14:16 @Description: 更新操作接口 */
public interface IUpdateService {
  /**
   * 简单的更新语法
   *
   * @return
   */
  Integer updateSimple();

  /**
   * 根据实体更新语法
   *
   * @param req 实体参数
   * @return
   */
  Integer updateByEntity(TestFluentMybatisEntity req);

  /**
   * 根据排除项更新语法
   *
   * @param req 实体参数
   * @return
   */
  Integer updateByExclude(TestFluentMybatisEntity req);

  /**
   * 使用applyFunc更新语法
   *
   * @return
   */
  Integer updateByApplyFunc();
}
