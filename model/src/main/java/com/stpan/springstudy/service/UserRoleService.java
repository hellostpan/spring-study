package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findListByUserId(Integer userId);
    List<UserRole> findListByRoleId(Integer roleId);
}
