package com.hy.fmp.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.hy.fmp.dto.req.PageReq;
import com.hy.fmp.fluent.entity.TestFluentMybatisEntity;

/**
 * @Program: fluent-mybatis-project
 * @ClassName: ISelectService
 * @Author: huyi
 * @Date: 2021-10-24 22:57
 * @Description: 查询操作接口
 * @Version: V1.0
 */
public interface ISelectService {
    StdPagedList<TestFluentMybatisEntity> selectAllByPage(PageReq pageReq);
}
