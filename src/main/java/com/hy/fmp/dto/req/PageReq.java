package com.hy.fmp.dto.req;

import lombok.Data;

/**
 * @Program: fluent-mybatis-project @ClassName: PageReq @Author: huyi @Date: 2021-10-24
 * 23:21 @Description: 分页参数 @Version: V1.0
 */
@Data
public class PageReq {
  /** 每页数量 */
  private Integer size;
  /** 页码 */
  private Integer page;
}
