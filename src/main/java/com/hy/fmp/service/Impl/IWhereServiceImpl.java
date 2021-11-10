package com.hy.fmp.service.Impl;

import cn.hutool.core.convert.Convert;
import cn.org.atool.fluent.mybatis.If;
import cn.org.atool.fluent.mybatis.base.model.SqlOp;
import com.hy.fmp.fluent.Ref;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import com.hy.fmp.fluent.wrapper.TestFluentMybatisQuery;
import com.hy.fmp.service.IWhereService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @Author huyi @Date 2021/11/8 20:10 @Description: where语法接口实现类 */
@Slf4j
@Service
public class IWhereServiceImpl implements IWhereService {
  @Autowired private TestFluentMybatisMapper testFluentMybatisMapper;

  @Override
  public List<TestFluentMybatisEntity> query1() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.age().ge(30).end());
  }

  @Override
  public List<TestFluentMybatisEntity> query2() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.age().in(new int[] {30, 78, 64}).end());
  }

  @Override
  public List<TestFluentMybatisEntity> query3() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.age().between(10, 50).end());
  }

  @Override
  public List<TestFluentMybatisEntity> query4() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.age().isNull().end());
  }

  @Override
  public List<TestFluentMybatisEntity> query5() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .age()
            .ge(30)
            .and
            .exists("select 1 from test_fluent_mybatis where name=?", "李四")
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query6() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .age()
            .ge(30)
            .and
            .exists(q -> q.select.name().end().where.name().eq("李四").end())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query7() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .id()
            .in(
                new TestFluentMybatisQuery()
                    .select
                    .apply("id")
                    .end()
                    .where
                    .age()
                    .between(10, 50)
                    .end())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query8() {
    TestFluentMybatisEntity query = new TestFluentMybatisEntity().setAge(18).setDelFlag(0);
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.eqByEntity(query).end());
  }

  @Override
  public List<TestFluentMybatisEntity> query9() {
    TestFluentMybatisEntity query = new TestFluentMybatisEntity().setAge(18).setDelFlag(0);
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .eqByEntity(query, Ref.Field.TestFluentMybatis.age, Ref.Field.TestFluentMybatis.name)
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query10() {
    TestFluentMybatisEntity query = new TestFluentMybatisEntity().setAge(18).setDelFlag(0);
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.eqByExclude(query).end());
  }

  @Override
  public List<TestFluentMybatisEntity> query11() {
    TestFluentMybatisEntity query = new TestFluentMybatisEntity().setAge(18).setDelFlag(0);
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .eqByExclude(
                query, Ref.Field.TestFluentMybatis.name, Ref.Field.TestFluentMybatis.createTime)
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query12() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .id()
            .in(q -> q.selectId().where.id().ge(4).end())
            .and(q -> q.where.age().ge(30).and.age().isNull(false).end())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query13() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .id()
            .in(q -> q.selectId().where.id().lt(3).end())
            .or(q -> q.where.age().isNull().end())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query14() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .id()
            .in(q -> q.selectId().where.id().lt(3).end())
            .or(
                q1 ->
                    q1.where
                        .and(q2 -> q2.where.age().notNull().end())
                        .and(q2 -> q2.where.age().ge(50).end())
                        .end())
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query15() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery().where.name().apply(SqlOp.EQ, "李四").age().apply("> 20").end());
  }

  @Override
  public List<TestFluentMybatisEntity> query16() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .applyFunc("name = ?", "李四")
            .createTime()
            .applyFunc(SqlOp.LT, "DATE_ADD(create_time, INTERVAL ? DAY)", 1)
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query17() {
    int id = 5;
    String name = "王五";
    int age = 30;
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .id()
            .ge(id, i -> i > 4)
            .and
            .name()
            .eq(name, n -> If.notBlank(n) && !n.contains("王五"))
            .and
            .age()
            .lt(age, a -> If.notEmpty(a) && a <= 30)
            .end());
  }

  @Override
  public List<TestFluentMybatisEntity> query18() {
    return testFluentMybatisMapper.listEntity(
        new TestFluentMybatisQuery()
            .where
            .applyIf(args -> Convert.toInt(args[0]) > 0, "age", SqlOp.BETWEEN, 20, 50)
            .end());
  }
}
