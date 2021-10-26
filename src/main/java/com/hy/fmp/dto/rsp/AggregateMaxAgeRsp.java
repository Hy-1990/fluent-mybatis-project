package com.hy.fmp.dto.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @Author huyi @Date 2021/10/26 14:15 @Description: 聚合最大年龄返回体 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AggregateMaxAgeRsp {
  private String name;
  private Integer maxAge;
}
