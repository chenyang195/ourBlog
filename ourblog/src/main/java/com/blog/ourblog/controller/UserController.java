package com.blog.ourblog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.ourblog.entity.User;
import com.blog.ourblog.service.UserService;
import com.blog.ourblog.util.MD5Encrypt;
import com.blog.ourblog.util.VerificationCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.io.*;



@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/reg")
    public String reg(@RequestParam("username")String username, @RequestParam("password")String password,@RequestParam("password1")String password1, @RequestParam("verify")String verify,Model model,HttpServletRequest request){
        System.out.println("执行到这里了");
        HttpSession session = request.getSession();
        System.out.println("执行到这里了1");
        if (session.getAttribute("verValue")==null){
            System.out.println("执行到这里了2");
            return "/register";

        }
        String verValue = session.getAttribute("verValue").toString();
        System.out.println("执行到这里了3");
        if(!password.equals(password1)){
            System.out.println("执行到这里了4");
            model.addAttribute("msg","两次密码不一致");
            return "/register";
        }
        System.out.println("执行到这里了5");
        if(!(verify.equalsIgnoreCase(verValue))){
            model.addAttribute("msg","验证码错误");
            System.out.println("执行到这里了6");
            return "/register";
        }
        System.out.println("执行到这里了7");
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
    public String log(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("verify")String verify, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("verValue")==null){
            return "/login";
        }
        String verValue = session.getAttribute("verValue").toString();


        if(!(verify.equalsIgnoreCase(verValue))){
            model.addAttribute("msg","验证码错误");
            return "/login";
        }


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
    @ResponseBody
    @RequestMapping("/getVerificationCode")
    public void getVerificationCode(HttpServletResponse response,HttpServletRequest request){
        String verificationCode ="";
        BufferedOutputStream bos;
        HttpSession session = request.getSession();

        try {
            bos = new BufferedOutputStream( response.getOutputStream());
            String value = VerificationCodeUtil.getVerificationCode(bos);
            bos.flush();
            bos.close();
           session.setAttribute("verValue",value);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
