package com.blog.ourblog.controller;

import com.blog.ourblog.entity.User;
import com.blog.ourblog.service.UserService;
import com.blog.ourblog.util.MD5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;



@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/reg")
    public String reg(@RequestParam("username")String username, @RequestParam("password")String password,Model model){
        User user = new User();
        user.setUsername(username);
        Object credentials = password;
        String pass = MD5Encrypt.encrypt(username,credentials).toString();
        System.out.println(pass);
        user.setPassword(pass);
        user.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        //尝试注册
        Integer result = userService.addUser(user);
        if(result.equals(-1)){
            model.addAttribute("msg","用户名已存在！");
            return "/register";
        }
         model.addAttribute("msg","注册成功请登录！");
         return "/login";
    }

    @RequestMapping("/log")
    public String log(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpServletRequest request){
        /**
         * 使用shiro编写认证
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        // 获取保存的URL

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
        if (savedRequest == null || savedRequest.getRequestUrl() == null) {
            return "test";
        }
        return "redirect:" + savedRequest.getRequestUrl();

    }
}
