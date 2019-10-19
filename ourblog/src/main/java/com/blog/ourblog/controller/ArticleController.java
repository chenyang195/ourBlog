package com.blog.ourblog.controller;


import com.alibaba.fastjson.JSON;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String pushEssay(@RequestParam("title")String title,@RequestParam("synopsis")String synopsis,@RequestParam("content")String content,@RequestParam("sign")String sign){
        Integer result =  articleService.addArticle(title,synopsis,content);
        if(result>0&&sign.equals("2")){
            Integer result2 = articleService.changeStatus(result,2);

        }
        System.out.println(result);
        return "result";
    }

    @RequestMapping("/showArticle")
    public String showArticle(@RequestParam("articleId")Integer articleId, Model model){
        //Integer intId = Integer.parseInt(articleId);
        Article article = articleService.getArticleAll(articleId);
        model.addAttribute("article",article);
        return "article";
    }
}
