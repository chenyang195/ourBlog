package com.blog.ourblog.controller;

import com.blog.ourblog.util.VerificationCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

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
    public String login(Model model){


        return "login";
    }

    @RequestMapping("/noAuth")
    public String noauth(){
        return "noAuth";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }
}
