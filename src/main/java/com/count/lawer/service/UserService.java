package com.count.lawer.service;

import com.count.lawer.bean.User;
import com.count.lawer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    public User findUserByAccount(String account){
        return userMapper.findUserByAccount(account);
    }

    public Integer saveUser(User user){
        System.out.println(user.getToken());
        return userMapper.saveUser(user);
    }
}
