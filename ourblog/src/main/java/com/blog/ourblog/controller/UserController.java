package com.blog.ourblog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/noAuth")
    public String noauth(){
        return "noAuth";
    }

    @RequestMapping("/log")
    public String log(@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        /**
         * 使用shiro编写认证
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //3.执行登录方法
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            model.addAttribute("msg","用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "/login";
        }
        return "test";
    }
}
