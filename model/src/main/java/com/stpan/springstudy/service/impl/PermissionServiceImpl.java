package com.stpan.springstudy.service.impl;

import com.stpan.springstudy.mapper.PermissionMapper;
import com.stpan.springstudy.pojo.*;
import com.stpan.springstudy.service.PermissionService;
import com.stpan.springstudy.service.RolePermissionService;
import com.stpan.springstudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Permission> findList(PermissionExample example) {
        return permissionMapper.selectByExample(example);
    }

    @Override
    public List<Permission> findListByUserId(Integer userId) {
        List<Role> list = roleService.findRoles(userId);
        List<RolePermission> rolePermissions = new ArrayList<>();
        for (Role role:list){
            rolePermissions.addAll(rolePermissionService.findListByRoleId(role.getId()));
        }
        List<Permission> permissions = new ArrayList<>();
        for (RolePermission rolePermission:rolePermissions){
            permissions.add(permissionMapper.selectByPrimaryKey(rolePermission.getPermissionId()));
        }
        return permissions;
    }
}
