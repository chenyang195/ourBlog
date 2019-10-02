package com.blog.ourblog.service;

import com.blog.ourblog.entity.User;

import org.springframework.stereotype.Service;


public  interface UserService {
    public User fingByUserName(String username);
    public Integer addUser(User user);
    public  Integer updateLocation(String location,String username);
}
