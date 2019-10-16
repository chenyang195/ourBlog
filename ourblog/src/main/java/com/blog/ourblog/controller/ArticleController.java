package com.blog.ourblog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.service.ArticleService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;


@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @ResponseBody
    @RequestMapping("/getHomePage")
    public String getHomePage(){
        Page page = articleService.getHomePage(0,5);

        return JSON.toJSON(page).toString();
    }

    @ResponseBody
    @RequestMapping("/pushEssay")
    public String pushEssay(@RequestParam("title")String title,@RequestParam("synopsis")String synopsis,@RequestParam("content")String content){
        Integer result = articleService.addArticle(title,synopsis,content);
        System.out.println(result);
        return "-1";
    }
}
