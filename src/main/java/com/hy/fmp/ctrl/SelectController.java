package com.hy.fmp.ctrl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.github.pagehelper.PageInfo;
import com.hy.fmp.dto.Result;
import com.hy.fmp.dto.req.PageReq;
import com.hy.fmp.enm.ErrorCode;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.service.ISelectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Program: fluent-mybatis-project @ClassName: SelectController @Author: huyi @Date: 2021-10-24
 * 22:43 @Description: 查询控制层 @Version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/select")
@Api(tags = "查询操作")
public class SelectController {

  @Autowired private ISelectService selectService;

  @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
  @RequestMapping(value = "/selectAllPage", method = RequestMethod.POST)
  @ResponseBody
  public Result<StdPagedList<TestFluentMybatisEntity>> selectAllPage(@RequestBody PageReq pageReq) {
    try {
      return Result.ok(selectService.selectAllByPage(pageReq));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "分页查询所有数据2", notes = "分页查询所有数据2")
  @RequestMapping(value = "/selectAllPage2", method = RequestMethod.POST)
  @ResponseBody
  public Result<PageInfo<TestFluentMybatisEntity>> selectAllPage2(@RequestBody PageReq pageReq) {
    try {
      return Result.ok(selectService.selectAllByPage2(pageReq));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }
}
