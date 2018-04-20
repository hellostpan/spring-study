package com.stpan.springstudy.service.impl;

import com.stpan.springstudy.mapper.UserRoleMapper;
import com.stpan.springstudy.pojo.UserRole;
import com.stpan.springstudy.pojo.UserRoleExample;
import com.stpan.springstudy.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> findListByUserId(Integer userId) {
        UserRoleExample example = new UserRoleExample();
        example.or().andUserIdEqualTo(userId);
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public List<UserRole> findListByRoleId(Integer roleId) {
        UserRoleExample example = new UserRoleExample();
        example.or().andRoleIdEqualTo(roleId);
        return userRoleMapper.selectByExample(example);
    }
}
