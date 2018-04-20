package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.User;
import com.stpan.springstudy.pojo.UserExample;

import java.util.List;

/**
 * author:  STPAN
 * time:    2018/4/9 21:23
 */
public interface UserService {
    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public User queryUserById(Integer userId);

    public List<User> queryUserList(UserExample example);

    public List<User> queryUserListPaged(UserExample example, Integer page, Integer pageSize);

    public User queryUserByIdCustom(Integer userId);

    public void saveUserTransactional(User user);
}
