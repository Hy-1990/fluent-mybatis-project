package com.hy.fmp.service;

import com.hy.fmp.dto.rsp.AggregateAgeSumAvgAndCountRsp;
import com.hy.fmp.dto.rsp.AggregateApplyRsp;
import com.hy.fmp.dto.rsp.AggregateMaxAgeRsp;

import java.util.List;

/** @Author huyi @Date 2021/10/26 10:51 @Description: 聚合查询接口 */
public interface IAggregateService {
  /**
   * 获取年龄最小值
   *
   * @return 年龄
   */
  Integer getAgeMin();

  /**
   * 根据名字分组，获取年龄最大的数据
   *
   * @return List
   */
  List<AggregateMaxAgeRsp> getAgeMaxByName();

  /**
   * 根据名字分组，获取年龄总和、平均值、数量
   *
   * @return List
   */
  List<AggregateAgeSumAvgAndCountRsp> getAgeSumAvgCountByName();

  /**
   * 应用语句
   *
   * @return 应用语句返回体
   */
  List<AggregateApplyRsp> getApply();
}
