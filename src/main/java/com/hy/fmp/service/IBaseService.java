package com.hy.fmp.service;

import com.hy.fmp.dto.req.TestFluentMybatisQueryReq;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;

import java.util.List;

/** @Author huyi @Date 2021/10/20 17:10 @Description: 基础操作接口 */
public interface IBaseService {
  /**
   * 新增/修改接口
   *
   * @param param 表实体
   * @return 表实体
   */
  TestFluentMybatisEntity insertOrUpdate(TestFluentMybatisEntity param);

  /**
   * 查询接口1
   *
   * @param queryReq 查询请求
   * @return 列表
   */
  List<TestFluentMybatisEntity> query1(TestFluentMybatisQueryReq queryReq);

  /**
   * 查询接口2
   *
   * @param queryReq 查询请求
   * @return 列表
   */
  List<TestFluentMybatisEntity> query2(TestFluentMybatisQueryReq queryReq);

  /**
   * 删除接口
   *
   * @param id id
   */
  void deleteById(Integer id);
}
