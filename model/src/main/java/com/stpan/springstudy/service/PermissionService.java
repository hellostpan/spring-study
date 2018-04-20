package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.Permission;
import com.stpan.springstudy.pojo.PermissionExample;

import java.util.List;

public interface PermissionService {
    List<Permission> findList(PermissionExample example);
    List<Permission> findListByUserId(Integer userId);
}
