package com.stpan.springstudy.repository.ipl;


import com.stpan.springstudy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author:  STPAN
 * time:    2018/4/8 21:48
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
