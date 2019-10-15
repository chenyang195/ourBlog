package com.blog.ourblog.service;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.Page;

import java.util.HashMap;
import java.util.List;

public interface ArticleService {
    public Page getHomePage(Integer pageHead, Integer pageSize);
    public List<Article>getStick(Integer pageHead,Integer pageSize);
    public List<Article>getNew(Integer pageHead,Integer pageSize);
    public List<Article>getHot(Integer pageHead,Integer pageSize);
    public List<Article>getBan(Integer pageHead,Integer pageSize);

}
