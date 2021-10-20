package com.hy.fmp.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.hy.fmp.dto.req.TestFluentMybatisQueryReq;
import com.hy.fmp.fluent.dao.intf.TestFluentMybatisDao;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.fluent.helper.TestFluentMybatisMapping;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import com.hy.fmp.fluent.wrapper.TestFluentMybatisQuery;
import com.hy.fmp.service.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/** @Author huyi @Date 2021/10/20 17:10 @Description: 基础操作接口实现 */
@Slf4j
@Service
public class BaseServiceImpl implements IBaseService {

  @Autowired private TestFluentMybatisDao testFluentMybatisDao;
  @Autowired private TestFluentMybatisMapper testFluentMybatisMapper;

  @Override
  public TestFluentMybatisEntity insertOrUpdate(TestFluentMybatisEntity param) {
    testFluentMybatisDao.saveOrUpdate(param);
    return param;
  }

  @Override
  public List<TestFluentMybatisEntity> query1(TestFluentMybatisQueryReq queryReq) {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .selectAll()
            .where
            .age()
            .eq(queryReq.getAge())
            .and
            .name()
            .eq(queryReq.getName())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query2(TestFluentMybatisQueryReq queryReq) {
    if (StrUtil.hasEmpty(queryReq.getAge()) && StrUtil.hasEmpty(queryReq.getName())) {
      return testFluentMybatisMapper.listEntity(new TestFluentMybatisQuery().selectAll());
    }
    return testFluentMybatisMapper.listByMap(
        true,
        new HashMap<String, Object>() {
          {
            if (!StrUtil.hasEmpty(queryReq.getAge())) {
              this.put(TestFluentMybatisMapping.age.column, queryReq.getAge());
            }
            if (!StrUtil.hasEmpty(queryReq.getName())) {
              this.put(TestFluentMybatisMapping.name.column, queryReq.getName());
            }
          }
        });
  }

  @Override
  public void deleteById(Integer id) {
    testFluentMybatisMapper.deleteById(id);
  }
}
