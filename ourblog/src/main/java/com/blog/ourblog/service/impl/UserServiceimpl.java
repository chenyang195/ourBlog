package com.blog.ourblog.service.impl;


import com.blog.ourblog.constant.Constant;
import com.blog.ourblog.entity.LoginHistory;
import com.blog.ourblog.entity.User;
import com.blog.ourblog.mapper.UserMapper;
import com.blog.ourblog.service.IPService;
import com.blog.ourblog.service.RoleService;
import com.blog.ourblog.service.UserService;
import com.blog.ourblog.util.MD5Encrypt;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service

public class UserServiceimpl implements UserService {

    @Autowired
    private Constant constant;

    @Resource
    private UserMapper userMapper ;
    @Autowired
    IPService ipService;
    @Autowired
    RoleService roleService;
    @Override
    public User fingByUserName(String username) {

        return userMapper.findByUsername(username);
    }

    @Override

    public Map addUser(User user) {
        //设置默认头像
        String defaultImageURL =constant.getSource()+ "/default.jpeg";
        user.setImageURL(defaultImageURL);
        Map<String,String> map = new HashMap<>();
        //转换密码为加密后的
        String pass = MD5Encrypt.encrypt(user.getUsername(),user.getPassword()).toString();

        user.setPassword(pass);
        user.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        if (userMapper.findByUsername(user.getUsername())!=null){
            map.put("msg","用户名已存在！");
            map.put("result","-1");
            return map;
        }
        Integer result =  userMapper.insertUser(user);
        user = userMapper.findByUsername(user.getUsername());
        roleService.setDefaultRole(user.getId());
        map.put("msg","注册成功请登录！");
        map.put("result",result.toString());
        return map;
    }

    @Override
    public Integer updateLocation(String location, String username) {
        Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setIP(location);
        loginHistory.setTime(timestamp);
        loginHistory.setUserName(username);



        location =ipService.getLocation(location);
        if (location==null){
            location="未知";
        }
        loginHistory.setLocation(location);
        userMapper.insertLoginHistory(loginHistory);

        Integer result = userMapper.flushUserLogin(location,timestamp,username);
        return result;
    }

    @Override
    public String checkUserExist(String username) {
        String result ="no";
        if (userMapper.findByUsername(username)!=null){

            result = "yes";
        }

        return result;
    }

    @Override
    public void showUser(String userName, Model model) {
        User user = userMapper.findByUsername(userName);
        String imageURL = user.getImageURL();
        String[] strings = StringUtils.split(imageURL,"///");
        Integer len = strings.length;
        user.setImageURL("/showPhoto?imageName="+strings[len-1]);
        model.addAttribute("user",user);
    }
}
