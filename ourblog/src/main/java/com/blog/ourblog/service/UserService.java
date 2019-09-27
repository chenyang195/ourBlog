package com.blog.ourblog.service;

import com.blog.ourblog.entity.User;

import org.springframework.stereotype.Service;

@Service
public  interface UserService {
    public User fingByUserName(String username);
}
