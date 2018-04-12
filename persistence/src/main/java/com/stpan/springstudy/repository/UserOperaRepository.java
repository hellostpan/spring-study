package com.stpan.springstudy.repository;

import com.stpan.springstudy.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:  STPAN
 * time:    2018/3/25 20:11
 */
@Repository
public class UserOperaRepository {

    private ConcurrentHashMap<Integer,User> repository = new ConcurrentHashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户
     * @param user
     * @return
     */
    public boolean save(User user){
        //id从1开始自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        user.setBirthday(new Date());
        return repository.put(id,user)==null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
