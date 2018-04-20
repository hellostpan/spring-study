package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.RolePermission;

import java.util.List;

public interface RolePermissionService {
    List<RolePermission> findListByRoleId(Integer roleId);
    List<RolePermission> findListByPermissionId(Integer permissionId);

}
