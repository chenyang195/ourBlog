package com.blog.ourblog.service;

import com.blog.ourblog.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;


public  interface UserService {
    public User fingByUserName(String username);
    public Map addUser(User user);
    public  Integer updateLocation(String location,String username);
    public String checkUserExist(String username);
    public void showUser(String userName, Model model);
}
