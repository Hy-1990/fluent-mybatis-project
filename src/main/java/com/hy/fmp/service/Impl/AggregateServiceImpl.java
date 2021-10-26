package com.hy.fmp.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.hy.fmp.dto.rsp.AggregateAgeSumAvgAndCountRsp;
import com.hy.fmp.dto.rsp.AggregateApplyRsp;
import com.hy.fmp.dto.rsp.AggregateMaxAgeRsp;
import com.hy.fmp.fluent.mapper.TestFluentMybatisMapper;
import com.hy.fmp.fluent.wrapper.TestFluentMybatisQuery;
import com.hy.fmp.service.IAggregateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** @Author huyi @Date 2021/10/26 10:53 @Description: 聚合查询接口实现类 */
@Slf4j
@Service
public class AggregateServiceImpl implements IAggregateService {
  @Autowired private TestFluentMybatisMapper testFluentMybatisMapper;

  @Override
  public Integer getAgeMin() {
    Map<String, Object> result =
        testFluentMybatisMapper
            .findOneMap(new TestFluentMybatisQuery().select.min.age("minAge").end())
            .orElse(null);
    return result != null ? Convert.toInt(result.get("minAge"), 0) : 0;
  }

  @Override
  public List<AggregateMaxAgeRsp> getAgeMaxByName() {
    List<Map<String, Object>> result =
        testFluentMybatisMapper.listMaps(
            new TestFluentMybatisQuery()
                .select
                .name()
                .max
                .age("maxAge")
                .end()
                .groupBy
                .name()
                .end());
    if (result != null && result.size() != 0) {
      List<AggregateMaxAgeRsp> list = new ArrayList<>();
      result.forEach(
          x -> list.add(BeanUtil.fillBeanWithMapIgnoreCase(x, new AggregateMaxAgeRsp(), false)));
      return list;
    } else {
      return null;
    }
  }

  @Override
  public List<AggregateAgeSumAvgAndCountRsp> getAgeSumAvgCountByName() {
    List<Map<String, Object>> result =
        testFluentMybatisMapper.listMaps(
            new TestFluentMybatisQuery()
                .select
                .name()
                .sum
                .age("sum")
                .avg
                .age("avg")
                .count("count")
                .end()
                .groupBy
                .name()
                .end());
    if (result != null && result.size() != 0) {
      List<AggregateAgeSumAvgAndCountRsp> list = new ArrayList<>();
      result.forEach(
          x ->
              list.add(
                  BeanUtil.fillBeanWithMapIgnoreCase(
                      x, new AggregateAgeSumAvgAndCountRsp(), false)));
      return list;
    } else {
      return null;
    }
  }

  @Override
  public List<AggregateApplyRsp> getApply() {
    List<Map<String, Object>> result =
        testFluentMybatisMapper.listMaps(
            new TestFluentMybatisQuery()
                .select
                .apply("name")
                .createTime("createTime")
                .apply("min(age) as minAge", "max(create_time) as maxTime")
                .end()
                .groupBy
                .name()
                .createTime()
                .end());
    if (result != null && result.size() != 0) {
      List<AggregateApplyRsp> list = new ArrayList<>();
      result.forEach(
          x -> list.add(BeanUtil.fillBeanWithMapIgnoreCase(x, new AggregateApplyRsp(), false)));
      return list;
    } else {
      return null;
    }
  }
}
