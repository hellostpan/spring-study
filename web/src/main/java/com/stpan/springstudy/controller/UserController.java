package com.stpan.springstudy.controller;

import com.stpan.springstudy.pojo.User;
import com.stpan.springstudy.pojo.UserExample;
import com.stpan.springstudy.repository.ipl.UserRepository;
import com.stpan.springstudy.service.UserService;
import com.stpan.springstudy.utils.Result;
import com.stpan.springstudy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * author:  STPAN
 * time:    2018/3/25 20:22
 */
@RestController
public class UserController {

    @Value("${server.port}")//读取配置文件里的字段值
    private String serverPort;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    /*@RequestMapping("/person/save")
    @ResponseBody
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name+serverPort);
        if(userRepository.save(user)){
            System.out.printf("用户对象: %s 保存成功",user);
        };
        return user;
    }*/

    @RequestMapping("/errorTest")
    public String error(@RequestParam String name) {
        //int i =  1/0;
        System.out.println("-----error----");
        return "error";
    }

    @GetMapping(value = "/userList")
    public Result userList() {
        System.out.println("--------userList--------");
        return ResultUtil.success(userService.queryUserList(new UserExample()));
    }

    @GetMapping(value = "/userListPage")
    public List<User> userListPage(Integer page) {
        System.out.println("--------userListPage--------");
        return userService.queryUserListPaged(new UserExample(), page, 5);
    }

    @GetMapping(value = "/userListCustom")
    @Transactional(propagation = Propagation.SUPPORTS)//如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    public User userListCustom(Integer userId) {
        System.out.println("--------userListCustom--------");
        return userService.queryUserByIdCustom(userId);
    }

    @GetMapping("/userSave")
    @Transactional(propagation = Propagation.REQUIRED)//如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
    public String insert() {
        User user = new User();
        user.setName("stp");
        user.setBirthday(new Date());
        userService.saveUser(user);
        return "success";
    }

    @GetMapping("/testTest")
    public User testTest() {
        User user = new User();
        user.setBirthday(new Date());
        user.setId(10);
        user.setName("hello");
        return user;
    }


}
