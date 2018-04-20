package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.Role;
import com.stpan.springstudy.pojo.RoleExample;

import java.util.List;

public interface RoleService {
    List<Role> findRoles(RoleExample example);
    List<Role> findRoles(Integer userId);
}
