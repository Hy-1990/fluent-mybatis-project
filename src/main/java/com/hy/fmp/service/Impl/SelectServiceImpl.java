package com.hy.fmp.service.Impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.fmp.dto.req.PageReq;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import com.hy.fmp.fluent.wrapper.TestFluentMybatisQuery;
import com.hy.fmp.service.ISelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: fluent-mybatis-project @ClassName: SelectServiceImpl @Author: huyi @Date: 2021-10-24
 * 23:37 @Description: 查询接口实现类 @Version: V1.0
 */
@Slf4j
@Service
public class SelectServiceImpl implements ISelectService {
  @Autowired private TestFluentMybatisMapper testFluentMybatisMapper;

  @Override
  public StdPagedList<TestFluentMybatisEntity> selectAllByPage(PageReq pageReq) {
    return testFluentMybatisMapper.stdPagedEntity(
        new TestFluentMybatisQuery()
            .selectAll()
            .limit(pageReq.getPage() * pageReq.getSize(), pageReq.getSize()));
  }

  @Override
  public PageInfo<TestFluentMybatisEntity> selectAllByPage2(PageReq pageReq) {
    PageHelper.startPage(pageReq.getPage(), pageReq.getSize());
    return new PageInfo<>(
        testFluentMybatisMapper.listEntity(new TestFluentMybatisQuery().selectAll()));
  }
}
