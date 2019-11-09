package com.blog.ourblog.controller;


import com.blog.ourblog.entity.User;
import com.blog.ourblog.service.UserService;

import com.blog.ourblog.util.VerificationCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.io.*;
import java.util.Map;



@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/reg")
    public String reg(@RequestParam("username")String username, @RequestParam("password")String password,@RequestParam("password1")String password1, @RequestParam("verify")String verify,Model model,HttpServletRequest request){

        HttpSession session = request.getSession();


        if (session.getAttribute("verValue")==null){
            System.out.println(session.getAttribute("verValue"));
            return "user/register";
        }

        String verValue = session.getAttribute("verValue").toString();


        if(!password.equals(password1)){
            model.addAttribute("msg","两次密码不一致");
            return "user/register";
        }

        if(!(verify.equalsIgnoreCase(verValue))){
            model.addAttribute("msg","验证码错误");
            return "user/register";
        }

        User user = new User();
        user.setUsername(username);
        Object credentials = password;
        user.setPassword(password);

        //尝试注册
        Map info = userService.addUser(user);
        if(info.get("result").equals("-1")){
            model.addAttribute("msg",info.get("msg"));
            return "user/register";
        }
         model.addAttribute("msg",info.get("msg"));
         return "/login";
    }

    @RequestMapping("/log")
    public String log(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("verify")String verify, Model model, HttpServletRequest request){


        HttpSession session = request.getSession();
        String addr = request.getRemoteAddr();
        if (session.getAttribute("verValue")==null){
            return "/login";
        }

        String verValue = session.getAttribute("verValue").toString();

        if(!(verify.equalsIgnoreCase(verValue))){
            model.addAttribute("msg","验证码错误");
            return "/login";
        }
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        String remeberme = request.getParameter("remeberme");
        if(remeberme!=null){
            if (remeberme.equals("on")){
                token.setRememberMe(true);
            }

        }
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
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
            userService.updateLocation(addr,username);
            return "index";


        }
        //更新登录记录

        userService.updateLocation(addr,username);

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
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());

        }


    }
    @RequestMapping("/logoutme")
    public void logout(HttpServletResponse response,HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Cookie[] cookies =request.getCookies();
        for (Cookie cookie:cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);

        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());
        }


    }

    @ResponseBody
    @RequestMapping("/checkUserExist")
    public String checkUserExist(@RequestParam("username")String username){
        String userExist = userService.checkUserExist(username);
        return userExist;
    }
    @RequestMapping("/user")
    private String user(@RequestParam("userName")String userName,Model model){
        userService.showUser(userName,model);
        return "showUser";
    }

}
