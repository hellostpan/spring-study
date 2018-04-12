package com.stpan.springstudy.mapper;

import com.stpan.springstudy.pojo.User;

import java.util.List;

/**
 * author:  STPAN
 * time:    2018/4/10 20:46
 */
public interface UserMapperCustom {
    List<User> selectUser(Integer userId);
}
