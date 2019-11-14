package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.ArticleInfos;
import com.blog.ourblog.entity.Icon;
import com.blog.ourblog.entity.Page;
import com.blog.ourblog.mapper.ArticleMapper;
import com.blog.ourblog.mapper.IconMapper;
import com.blog.ourblog.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Resource
    IconMapper iconMapper;
    @Override
    public Page getHomePage(Integer pageHead, Integer pageSize) {
        Page page = new Page();
        page.setStickNum(articleMapper.getStickArticleNumber());
        page.setArticleNum(articleMapper.getArticleNumber());
        List<Article> listStick = articleMapper.getStickArticleInformation();
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
    public List<Article> getStick() {
        List<Article> listStick = articleMapper.getStickArticleInformation();
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
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            return -1;
        }
        article.setUserName(userName);
        article.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));


        articleMapper.addArticle(article);
        Integer result = article.getArticleId();
        if (result==null){
            result = -1;
        }

        return result;
    }

    @Override
    public Integer changeStatus(Integer articleId,Integer sign) {
        Integer result = -1;
        if(sign==0){
            result = articleMapper.cancelBanArticle(articleId);
        }
        if (sign==1){
            result = articleMapper.banArticle(articleId);
        }
        if (sign==2){
            result = articleMapper.draftArticle(articleId);
        }
        return result;
    }

    @Override
    public Article getArticleAll(Integer articleId) {
        Article article;
        article = articleMapper.getArticle(articleId);

        return article;
    }

    @Override
    public ArticleInfos getHotArticleInfos(Integer pageHead,Integer pageSize) {
        List<Article> articleList = articleMapper.getHotArticleInformation(pageHead,pageSize);
        Integer articleNum = articleMapper.getArticleNumber();
        ArticleInfos articleInfos = new ArticleInfos();
        articleInfos.setArticleList(articleList);
        articleInfos.setArticleNum(articleNum);
        return articleInfos;
    }

    @Override
    public ArticleInfos getNewArticleInfos(Integer pageHead,Integer pageSize) {
        List<Article> articleList = articleMapper.getNewArticleInformation(pageHead,pageSize);
        Integer articleNum = articleMapper.getArticleNumber();
        ArticleInfos articleInfos = new ArticleInfos();
        articleInfos.setArticleList(articleList);
        articleInfos.setArticleNum(articleNum);
        return articleInfos;
    }

    @Override
    public Integer changeIcon(Integer articleId, Integer sign) {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            return -1;
        }
        Icon icon = new Icon();
        icon.setArticleId(articleId);
        icon.setType(sign);
        icon.setUserName(userName);
        Integer id = iconMapper.getIdByIcon(icon);
        if (id !=null){

            return 1;
        }else {
            icon.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
            iconMapper.addIcon(icon);
            updateArticleIcon(articleId,sign);
           return  1;
        }



    }

    @Override
    public List<Article> getPersonArt(Integer sign) {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            return null;
        }
        return articleMapper.getPersonArt(sign,userName);
    }

    @Override
    public Integer operateArt(Integer articleId, Integer sign) {
        Article article = articleMapper.getArticleInformation(articleId);
        if (article==null){
            return -1;
        }
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            return -1;
        }
        if (!userName.equals(article.getUserName())){
            return -1;
        }
        if (sign==1){
            return articleMapper.deleteArticle(articleId);
        }
        if (sign==2){
            Timestamp timestamp =new java.sql.Timestamp(new java.util.Date().getTime());
            return articleMapper.publishArticle(articleId,timestamp);
        }
        return -1;
    }

    @Override
    public Integer updateArticle(String articleTitle, String synopsis, String content,String articleId) {
        Integer intArticleId = Integer.parseInt(articleId.trim());
        if (intArticleId==null){
            return -1;
        }
        Article article = articleMapper.getArticleInformation(intArticleId);
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            return -1;
        }
        if (!userName.equals(article.getUserName())){
            return  -1;
        }
        article.setContent(content);
        article.setSynopsis(synopsis);
        article.setTitle(articleTitle);
        article.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));


        Integer result =articleMapper.updateArticle(article);


        if (result==null){
            result = -1;
        }
        if (result>0){
            result = article.getArticleId();
        }

        return result;
    }

    void updateArticleIcon(Integer articleId,Integer sign){
        Article article = articleMapper.getArticleInformation(articleId);
        if (sign==1){
            article.setStarNum(article.getStarNum()+1);
        }else if(sign==2){
            article.setPraiseNum(article.getPraiseNum()+1);
        }else if(sign==3){
            article.setTreadNum(article.getTreadNum()+1);
        }
        articleMapper.updateArticleInformation(article);
    }
}
