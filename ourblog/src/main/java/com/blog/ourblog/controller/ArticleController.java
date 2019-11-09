package com.blog.ourblog.controller;


import com.alibaba.fastjson.JSON;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.ArticleInfos;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
            return result2.toString();

        }
        System.out.println(result);
        return result.toString();
    }

    @RequestMapping("/showArticle")
    public String showArticle(@RequestParam("articleId")Integer articleId, Model model){
        //Integer intId = Integer.parseInt(articleId);
        Article article = articleService.getArticleAll(articleId);
        model.addAttribute("article",article);
        return "article";
    }
    @ResponseBody
    @RequestMapping("/getHot")
    public String getHot(@RequestParam("pageNum")String pageNum){
        Integer pageHead = (Integer.parseInt(pageNum)-1)*10;
        if (pageHead.intValue()<0){

            pageHead = 0;
        }
        ArticleInfos articleInfos = articleService.getHotArticleInfos(pageHead,10);
        return JSON.toJSON(articleInfos).toString();
    }

    @ResponseBody
    @RequestMapping("/getNew")
    public String getNew(@RequestParam("pageNum")String pageNum){
        Integer pageHead = (Integer.parseInt(pageNum)-1)*10;
        if (pageHead.intValue()<0){

            pageHead = 0;
        }
        ArticleInfos articleInfos = articleService.getNewArticleInfos(pageHead,10);
        return JSON.toJSON(articleInfos).toString();
    }

    @ResponseBody
    @RequestMapping("/getStick")
    public String getstick(){
        List<Article> list = articleService.getStick();
        Map<String,List<Article>> map = new HashMap<>();
        map.put("sticks",list);
        return JSON.toJSON(map).toString();
    }


    @ResponseBody
    @RequestMapping("/changeIcon")
    public String changeIcon(@RequestParam("articleId")String articleId,@RequestParam("sign")String sign){
        Integer intid =Integer.parseInt(articleId.trim());
        Integer intSign =Integer.parseInt(sign.trim());
        Integer res = articleService.changeIcon(intid,intSign);
        return res.toString();
    }
}
