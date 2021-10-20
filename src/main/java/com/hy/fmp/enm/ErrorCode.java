package com.hy.fmp.enm;

/** @Author huyi @Date 2021/10/20 17:19 @Description: 报错code */
public enum ErrorCode {
  /** 错误code */
  BASE_ERROR_CODE("10001"),
  ;

  private final String code;

  ErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
