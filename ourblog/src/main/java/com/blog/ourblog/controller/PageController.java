package com.blog.ourblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
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

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }
}
