package com.hy.fmp.service;

import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;

import java.util.List;

/** @Author huyi @Date 2021/11/8 19:48 @Description: where语法 */
public interface IWhereService {
  /**
   * 测试ge
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query1();

  /**
   * 测试in
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query2();

  /**
   * 测试between
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query3();

  /**
   * 测试is null
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query4();

  /**
   * 测试exist
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query5();

  /**
   * 测试exist lamdas
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query6();

  /**
   * 测试in lamdas
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query7();

  /**
   * 测试eqByEntity
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query8();

  /**
   * 测试eqByEntity 指定字段
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query9();

  /**
   * 测试eqByExclude
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query10();

  /**
   * 测试eqByExclude 指定字段
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query11();

  /**
   * 测试and 子查询
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query12();

  /**
   * 测试or 子查询
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query13();

  /**
   * 测试多重嵌套
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query14();

  /**
   * 测试apply SqlOp
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query15();

  /**
   * 测试apply func
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query16();

  /**
   * 测试条件设置语法
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query17();

  /**
   * 测试applyIf
   *
   * @return list
   */
  List<TestFluentMybatisEntity> query18();
}
