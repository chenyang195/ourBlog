package com.blog.ourblog.service;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.ArticleInfos;
import com.blog.ourblog.entity.Page;


import java.util.List;

public interface ArticleService {
    public Page getHomePage(Integer pageHead, Integer pageSize);
    public List<Article>getStick();
    public List<Article>getNew(Integer pageHead,Integer pageSize);
    public List<Article>getHot(Integer pageHead,Integer pageSize);
    public List<Article>getBan(Integer pageHead,Integer pageSize);
    public Integer addArticle(String articleTitle,String synopsis,String content);
    public Integer changeStatus(Integer articleId, Integer sign);
    public Article getArticleAll(Integer articleId);
    public ArticleInfos getHotArticleInfos(Integer pageHead,Integer pageSize);
    public ArticleInfos getNewArticleInfos(Integer pageHead,Integer pageSize);
    public Integer changeIcon(Integer articleId, Integer sign);
    public List<Article>getPersonArt(Integer sign);
    public Integer operateArt(Integer articleId, Integer sign);
    public Integer updateArticle(String articleTitle,String synopsis,String content,String articleId);

}
