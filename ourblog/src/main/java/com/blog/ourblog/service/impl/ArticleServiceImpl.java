package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.mapper.ArticleMapper;
import com.blog.ourblog.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Override
    public Page getHomePage(Integer pageHead, Integer pageSize) {
        Page page = new Page();
        page.setStickNum(articleMapper.getStickArticleNumber());
        page.setArticleNum(articleMapper.getArticleNumber());
        List<Article> listStick = articleMapper.getStickArticleInformation(pageHead,pageSize);
        List<Article> listNew = articleMapper.getNewArticleInformation(pageHead,pageSize);
        List<Article> listHot = articleMapper.getHotArticleInformation(pageHead,pageSize);
        Map<String,List<Article>> map = new HashMap<>();
        map.put("stick",listStick);
        map.put("new",listNew);
        map.put("hot",listHot);
        page.setArticleMap(map);

        return page;
    }

    @Override
    public List<Article> getStick(Integer pageHead, Integer pageSize) {
        List<Article> listStick = articleMapper.getStickArticleInformation(pageHead,pageSize);
        return listStick;
    }

    @Override
    public List<Article> getNew(Integer pageHead, Integer pageSize) {
        List<Article> listNew = articleMapper.getNewArticleInformation(pageHead,pageSize);
        return listNew;
    }

    @Override
    public List<Article> getHot(Integer pageHead, Integer pageSize) {
        List<Article> listHot = articleMapper.getHotArticleInformation(pageHead,pageSize);
        return listHot;
    }

    @Override
    public List<Article> getBan(Integer pageHead, Integer pageSize) {
        List<Article> listBan = articleMapper.getBanArticleInformation(pageHead,pageSize);
        return listBan;
    }

    @Override
    public Integer addArticle(String articleTitle, String synopsis, String content) {
        Article article = new Article();
        article.setContent(content);
        article.setSynopsis(synopsis);
        article.setTitle(articleTitle);
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        article.setUserName(userName);
        article.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));


        articleMapper.addArticle(article);
        Integer result = article.getArticleId();
        if (result==null){
            result = -1;
        }
        System.out.println(getClass().toString()+result);
        return result;
    }
}
