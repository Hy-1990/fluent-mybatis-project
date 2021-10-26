package com.hy.fmp.ctrl;

import com.hy.fmp.dto.Result;
import com.hy.fmp.dto.rsp.AggregateAgeSumAvgAndCountRsp;
import com.hy.fmp.dto.rsp.AggregateApplyRsp;
import com.hy.fmp.dto.rsp.AggregateMaxAgeRsp;
import com.hy.fmp.enm.ErrorCode;
import com.hy.fmp.service.IAggregateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @Author huyi @Date 2021/10/26 10:50 @Description: 聚合控制层 */
@Slf4j
@RestController
@RequestMapping("/aggregate")
@Api(tags = "聚合操作")
public class AggregateController {

  @Autowired private IAggregateService aggregateService;

  @ApiOperation(value = "获取最小年龄", notes = "获取最小年龄")
  @RequestMapping(value = "/getAgeMin", method = RequestMethod.GET)
  @ResponseBody
  public Result<Integer> getAgeMin() {
    try {
      return Result.ok(aggregateService.getAgeMin());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "根据年龄分组并获取最大年龄", notes = "根据年龄分组并获取最大年龄")
  @RequestMapping(value = "/getAgeMaxByName", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<AggregateMaxAgeRsp>> getAgeMaxByName() {
    try {
      return Result.ok(aggregateService.getAgeMaxByName());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "根据年龄分组并获取年龄和、平均年龄、数量", notes = "根据年龄分组并获取年龄和、平均年龄、数量")
  @RequestMapping(value = "/getAgeSumAvgCountByName", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<AggregateAgeSumAvgAndCountRsp>> getAgeSumAvgCountByName() {
    try {
      return Result.ok(aggregateService.getAgeSumAvgCountByName());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "根据名字获取最小年龄，使用语句", notes = "根据名字获取最小年龄，使用语句")
  @RequestMapping(value = "/getApply", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<AggregateApplyRsp>> getApply() {
    try {
      return Result.ok(aggregateService.getApply());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }
}
