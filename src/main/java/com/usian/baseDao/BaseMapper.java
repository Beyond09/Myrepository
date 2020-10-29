package com.usian.baseDao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zby
 * @create 2020-10-28 20:08
 */
public interface BaseMapper<T> extends Mapper<T> , MySqlMapper<T> {
}
