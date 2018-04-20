package com.stpan.springstudy.service;

import com.stpan.springstudy.pojo.User;
import com.stpan.springstudy.pojo.UserExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:  STPAN
 * time:    2018/4/14 20:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UerServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryUserList(){
        List<User> users = userService.queryUserList(new UserExample());
        Assert.assertNotNull(users);
    }
}
