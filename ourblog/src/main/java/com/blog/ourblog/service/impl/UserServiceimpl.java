package com.blog.ourblog.service.impl;


import com.blog.ourblog.entity.User;
import com.blog.ourblog.mapper.UserMapper;
import com.blog.ourblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service

public class UserServiceimpl implements UserService {

    @Resource
    private UserMapper userMapper ;
    @Override
    public User fingByUserName(String username) {

        return userMapper.findByUsername(username);
    }

    @Override

    public Integer addUser(User user) {
        if (userMapper.findByUsername(user.getUsername())!=null){
            return -1;
        }
        return  userMapper.insertUser(user);
    }
}
