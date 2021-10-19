package com.hy.fmp.test;

import com.hy.fmp.Application;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = Application.class)
public class InsertTest {
  @Autowired TestFluentMybatisMapper testFluentMybatisMapper;

  @Test
  public void testInsertDefaultValue() {
    // 插入数据
    testFluentMybatisMapper.insert(
        new TestFluentMybatisEntity()
            .setAge(18)
            .setName("法外狂徒张三")
            .setCreateTime(new Date())
            .setDelFlag(0));
  }
}
