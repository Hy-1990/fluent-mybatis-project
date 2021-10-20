package com.hy.fmp.dto;

import cn.hutool.json.JSONUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> {
  private String code = "0";
  private String message = "请求成功";
  private boolean success = true;
  private T data;

  public Result(String code, String message, boolean success) {
    this.code = code;
    this.message = message;
    this.success = success;
  }

  public Result(String code, String message, boolean success, T data) {
    this.code = code;
    this.message = message;
    this.success = success;
    this.data = data;
  }

  public Result(T data) {
    this.data = data;
  }

  /**
   * 针对异常返回响应体
   *
   * @param success 是否成功
   * @param code 错误码
   * @param message 错误信息
   */
  public Result(boolean success, String code, String message) {
    this.success = success;
    this.code = code;
    this.message = message;
  }

  public static <T> Result<T> ok(T obj) {
    return new Result<>(obj);
  }

  public static <T> Result<T> ok() {
    return new Result<>();
  }

  public static <T> Result<T> error(String code, String message) {
    return new Result<>(code, message, false);
  }

  public static <T> Result<T> error(String code, String message, T data) {
    return new Result<>(code, message, false, data);
  }

  public Result<T> setMsg(String message) {
    this.message = message;
    return this;
  }

  @Override
  public String toString() {
    return JSONUtil.toJsonStr(this);
  }
}
