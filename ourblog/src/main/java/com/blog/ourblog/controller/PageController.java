package com.blog.ourblog.controller;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.mapper.ArticleMapper;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @Resource
    ArticleMapper articleMapper;
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
    public String editor(HttpServletRequest request, Model model){

        String articleId = request.getParameter("articleId");
        if (articleId==null){
            return "editor";
        }
        Integer intArticleId = Integer.parseInt(articleId);
        if (intArticleId!=null){

            Article article = articleMapper.getArticle(intArticleId);
            if (article!=null){
                model.addAttribute("article",article);
                return "editor1";
            }
        }
        return "editor";
    }
    @RequestMapping("/yourself")
    public String yourself(HttpServletRequest request, Model model){
        String target = request.getParameter("target");
        if (target!=null){
            model.addAttribute("target",target);
        }
        return "personal";
    }




}
