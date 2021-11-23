package com.hy.fmp.ctrl;

import com.hy.fmp.dto.Result;
import com.hy.fmp.enm.ErrorCode;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.service.IUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** @Author huyi @Date 2021/11/22 14:22 @Description: 更新语法控制层 */
@Slf4j
@RestController
@RequestMapping("/update")
@Api(tags = "update语法")
public class UpdateController {
  @Autowired private IUpdateService updateService;

  @ApiOperation(value = "简单语法", notes = "简单语法")
  @RequestMapping(value = "/simple", method = RequestMethod.GET)
  @ResponseBody
  public Result<Integer> updateSimple() {
    try {
      return Result.ok(updateService.updateSimple());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "根据实体更新语法", notes = "根据实体更新语法")
  @RequestMapping(value = "/updateByEntity", method = RequestMethod.POST)
  @ResponseBody
  public Result<Integer> updateByEntity(@RequestBody TestFluentMybatisEntity req) {
    try {
      return Result.ok(updateService.updateByEntity(req));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "根据排除项更新语法", notes = "根据排除项更新语法")
  @RequestMapping(value = "/updateByExclude", method = RequestMethod.POST)
  @ResponseBody
  public Result<Integer> updateByExclude(@RequestBody TestFluentMybatisEntity req) {
    try {
      return Result.ok(updateService.updateByExclude(req));
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "使用applyFunc更新语法", notes = "使用applyFunc更新语法")
  @RequestMapping(value = "/updateByApplyFunc", method = RequestMethod.GET)
  @ResponseBody
  public Result<Integer> updateByApplyFunc() {
    try {
      return Result.ok(updateService.updateByApplyFunc());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }
}
