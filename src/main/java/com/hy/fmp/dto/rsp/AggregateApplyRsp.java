package com.hy.fmp.dto.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** @Author huyi @Date 2021/10/26 15:10 @Description: 聚合应用返回体 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AggregateApplyRsp {
  private String name;
  private Date createTime;
  private Integer minAge;
  private Date maxTime;
}
