package com.stpan.springstudy.service.impl;

import com.stpan.springstudy.mapper.RolePermissionMapper;
import com.stpan.springstudy.pojo.RolePermission;
import com.stpan.springstudy.pojo.RolePermissionExample;
import com.stpan.springstudy.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> findListByRoleId(Integer roleId) {
        RolePermissionExample example = new RolePermissionExample();
        example.or().andRoleIdEqualTo(roleId);
        return rolePermissionMapper.selectByExample(example);
    }

    @Override
    public List<RolePermission> findListByPermissionId(Integer permissionId) {
        RolePermissionExample example = new RolePermissionExample();
        example.or().andPermissionIdEqualTo(permissionId);
        return rolePermissionMapper.selectByExample(example);
    }
}
