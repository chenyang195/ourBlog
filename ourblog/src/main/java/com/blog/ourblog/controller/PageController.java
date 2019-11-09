package com.blog.ourblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/admin")
    public String test(){
        return "admin";
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

    @RequestMapping("/hotArticle")
    public String hotArticle(){
        return "hotArticle";
    }

    @RequestMapping("/newArticle")
    public String newArticle(){
        return "newArticle";
    }
    @RequestMapping("/editor")
    public String editor(){
        return "editor";
    }
    @RequestMapping("/yourself")
    public String yourself(){
        return "personal";
    }




}
