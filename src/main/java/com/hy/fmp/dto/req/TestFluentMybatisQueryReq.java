package com.hy.fmp.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @Author huyi @Date 2021/10/20 19:37 @Description: 查询条件 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestFluentMybatisQueryReq {
  private String age;
  private String name;
}
