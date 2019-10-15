package com.blog.ourblog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.service.ArticleService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



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
}
