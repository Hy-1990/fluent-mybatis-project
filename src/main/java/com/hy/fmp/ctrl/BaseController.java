package com.hy.fmp.ctrl;

import com.hy.fmp.dto.Result;
import com.hy.fmp.dto.req.TestFluentMybatisQueryReq;
import com.hy.fmp.enm.ErrorCode;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.service.IBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @Author huyi @Date 2021/10/20 17:04 @Description: 基础操作 */
@Slf4j
@RestController
@RequestMapping("/base")
@Api(tags = "基础操作")
public class BaseController {
  @Autowired private IBaseService baseService;

  @ApiOperation(value = "插入/更新数据", notes = "插入/更新数据")
  @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
  @ResponseBody
  public Result<TestFluentMybatisEntity> insertOrUpdate(
      @RequestBody TestFluentMybatisEntity param) {
    try {
      return Result.ok(baseService.insertOrUpdate(param));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "查询数据1", notes = "查询数据1")
  @RequestMapping(value = "/query1", method = RequestMethod.POST)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query1(
      @RequestBody TestFluentMybatisQueryReq queryReq) {
    try {
      return Result.ok(baseService.query1(queryReq));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "查询数据2", notes = "查询数据2")
  @RequestMapping(value = "/query2", method = RequestMethod.POST)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query2(
      @RequestBody TestFluentMybatisQueryReq queryReq) {
    try {
      return Result.ok(baseService.query2(queryReq));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "通过ID删除数据", notes = "通过ID删除数据")
  @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
  @ResponseBody
  public Result<Boolean> query2(@RequestParam Integer id) {
    try {
      baseService.deleteById(id);
      return Result.ok(true);
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), false);
    }
  }
}
