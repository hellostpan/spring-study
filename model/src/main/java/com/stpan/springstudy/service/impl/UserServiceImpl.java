package com.stpan.springstudy.service.impl;

import com.github.pagehelper.PageHelper;
import com.stpan.springstudy.mapper.UserMapper;
import com.stpan.springstudy.mapper.UserMapperCustom;
import com.stpan.springstudy.pojo.User;
import com.stpan.springstudy.pojo.UserExample;
import com.stpan.springstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:  STPAN
 * time:    2018/4/9 21:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> queryUserList(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> queryUserListPaged(UserExample example, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return userMapper.selectByExample(example);
    }

    @Override
    public User queryUserByIdCustom(Integer userId) {
        List<User> list = userMapperCustom.selectUser(userId);
        if (list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void saveUserTransactional(User user) {

    }
}
