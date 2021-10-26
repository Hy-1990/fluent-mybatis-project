package com.hy.fmp.dto.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @Author huyi @Date 2021/10/26 14:50 @Description: 聚合平均总和返回体 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AggregateAgeSumAvgAndCountRsp {
  private String name;
  private Integer sum;
  private Integer avg;
  private Integer count;
}
