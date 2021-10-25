package com.hy.fmp.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hy.fmp.dto.req.PageReq;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;

/**
 * @Program: fluent-mybatis-project @ClassName: ISelectService @Author: huyi @Date: 2021-10-24
 * 22:57 @Description: 查询操作接口 @Version: V1.0
 */
public interface ISelectService {
  /**
   * 分页查询
   *
   * @param pageReq 分页参数
   * @return 分页实体
   */
  StdPagedList<TestFluentMybatisEntity> selectAllByPage(PageReq pageReq);

  /**
   * 分页查询，使用pageHelper
   *
   * @param pageReq 分页参数
   * @return 页面实体
   */
  PageInfo<TestFluentMybatisEntity> selectAllByPage2(PageReq pageReq);
}
