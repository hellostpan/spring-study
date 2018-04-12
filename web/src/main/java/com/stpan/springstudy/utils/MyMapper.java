package com.stpan.springstudy.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * author:  STPAN
 * time:    2018/4/9 20:11
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
