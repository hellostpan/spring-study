package com.stpan.springstudy.service.impl;

import com.stpan.springstudy.mapper.RoleMapper;
import com.stpan.springstudy.pojo.Role;
import com.stpan.springstudy.pojo.RoleExample;
import com.stpan.springstudy.pojo.UserRole;
import com.stpan.springstudy.service.RoleService;
import com.stpan.springstudy.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<Role> findRoles(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Role> findRoles(Integer userId) {
        List<UserRole> list = userRoleService.findListByRoleId(userId);
        List<Role> roles = new ArrayList<>();
        for (UserRole userRole:list){
            roles.add(roleMapper.selectByPrimaryKey(userRole.getRoleId()));
        }
        return roles;
    }
}
