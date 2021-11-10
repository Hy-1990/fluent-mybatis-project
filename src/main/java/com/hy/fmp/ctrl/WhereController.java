package com.hy.fmp.ctrl;

import com.hy.fmp.dto.Result;
import com.hy.fmp.enm.ErrorCode;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;
import com.hy.fmp.service.IWhereService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @Author huyi @Date 2021/11/8 20:15 @Description: where语法控制层 */
@Slf4j
@RestController
@RequestMapping("/where")
@Api(tags = "where语法")
public class WhereController {
  @Autowired private IWhereService whereService;

  @ApiOperation(value = "where-ge语法", notes = "where-ge语法")
  @RequestMapping(value = "/ge", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query1() {
    try {
      return Result.ok(whereService.query1());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-in语法", notes = "where-in语法")
  @RequestMapping(value = "/in", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query2() {
    try {
      return Result.ok(whereService.query2());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-between语法", notes = "where-between语法")
  @RequestMapping(value = "/between", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query3() {
    try {
      return Result.ok(whereService.query3());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-isNull语法", notes = "where-isNull语法")
  @RequestMapping(value = "/isNull", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query4() {
    try {
      return Result.ok(whereService.query4());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-exist语法", notes = "where-exist语法")
  @RequestMapping(value = "/exist", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query5() {
    try {
      return Result.ok(whereService.query5());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-exist1语法", notes = "where-exist1语法")
  @RequestMapping(value = "/exist1", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query6() {
    try {
      return Result.ok(whereService.query6());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-in-sub语法", notes = "where-in-sub语法")
  @RequestMapping(value = "/in-sub", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query7() {
    try {
      return Result.ok(whereService.query7());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-eqByEntity1语法", notes = "where-eqByEntity1语法")
  @RequestMapping(value = "/eqByEntity1", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query8() {
    try {
      return Result.ok(whereService.query8());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-eqByEntity2语法", notes = "where-eqByEntity2语法")
  @RequestMapping(value = "/eqByEntity2", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query9() {
    try {
      return Result.ok(whereService.query9());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-eqByExclude1语法", notes = "where-eqByExclude1语法")
  @RequestMapping(value = "/eqByExclude1", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query10() {
    try {
      return Result.ok(whereService.query10());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-eqByExclude2语法", notes = "where-eqByExclude2语法")
  @RequestMapping(value = "/eqByExclude2", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query11() {
    try {
      return Result.ok(whereService.query11());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-and语法", notes = "where-and语法")
  @RequestMapping(value = "/and-sub-lamdas", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query12() {
    try {
      return Result.ok(whereService.query12());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-or语法", notes = "where-or语法")
  @RequestMapping(value = "/or-sub-lamdas", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query13() {
    try {
      return Result.ok(whereService.query13());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-多重嵌套语法", notes = "where-多重嵌套语法")
  @RequestMapping(value = "/multiple", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query14() {
    try {
      return Result.ok(whereService.query14());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-apply-sqlop", notes = "where-apply-sqlop")
  @RequestMapping(value = "/apply", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query15() {
    try {
      return Result.ok(whereService.query15());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-applyFunc", notes = "where-applyFunc")
  @RequestMapping(value = "/applyFunc", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query16() {
    try {
      return Result.ok(whereService.query16());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-条件设置", notes = "where-条件设置")
  @RequestMapping(value = "/condition", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query17() {
    try {
      return Result.ok(whereService.query17());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }

  @ApiOperation(value = "where-applyIf", notes = "where-applyIf")
  @RequestMapping(value = "/applyIf", method = RequestMethod.GET)
  @ResponseBody
  public Result<List<TestFluentMybatisEntity>> query18() {
    try {
      return Result.ok(whereService.query18());
    } catch (Exception exception) {
      return Result.error(ErrorCode.BASE_ERROR_CODE.getCode(), exception.getMessage(), null);
    }
  }
}
