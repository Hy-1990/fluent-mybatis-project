package com.hy.fmp.service.Impl;

import com.hy.fmp.fluent.Ref;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import com.hy.fmp.fluent.wrapper.TestFluentMybatisUpdate;
import com.hy.fmp.service.IUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @Author huyi @Date 2021/11/22 14:17 @Description: 更新接口实现类 */
@Slf4j
@Service
public class UpdateServiceImpl implements IUpdateService {
  @Autowired private TestFluentMybatisMapper testFluentMybatisMapper;

  @Override
  public Integer updateSimple() {
    return testFluentMybatisMapper.updateBy(
        new TestFluentMybatisUpdate()
            .set
            .name()
            .is("何九")
            .set
            .age()
            .isNull()
            .end()
            .where
            .id()
            .eq(2)
            .end());
  }

  @Override
  public Integer updateByEntity(TestFluentMybatisEntity req) {
    return testFluentMybatisMapper.updateBy(
        new TestFluentMybatisUpdate()
            .set
            .byEntity(req, Ref.Field.TestFluentMybatis.name, Ref.Field.TestFluentMybatis.age)
            .end()
            .where
            .id()
            .eq(2)
            .end());
  }

  @Override
  public Integer updateByExclude(TestFluentMybatisEntity req) {
    return testFluentMybatisMapper.updateBy(
        new TestFluentMybatisUpdate()
            .set
            .byExclude(req, TestFluentMybatisEntity::getAge, TestFluentMybatisEntity::getDelFlag)
            .end()
            .where
            .id()
            .eq(2)
            .end());
  }

  @Override
  public Integer updateByApplyFunc() {
    return testFluentMybatisMapper.updateBy(
        new TestFluentMybatisUpdate()
            .set
            .name()
            .applyFunc("concat(name, ?)", "_男")
            .set
            .age()
            .applyFunc("age+5")
            .end()
            .where
            .id()
            .eq(2)
            .end());
  }
}
