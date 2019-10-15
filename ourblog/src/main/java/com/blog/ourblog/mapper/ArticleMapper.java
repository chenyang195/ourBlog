package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public Integer addArticle(@Param("article") Article article);
    public Integer getArticleInformation(@Param("articleId")Integer articleId);
    public Integer getArticleNumber();
    public Article getArticle(@Param("articleId")Integer articleId);
    public List<Article> getStickArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Integer getStickArticleNumber();
    public List<Article> getHotArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public List<Article> getNewArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Integer getBanArticleNumber();
    public List<Article> getBanArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Integer updateArticle(@Param("article") Article article);
    public Integer banArticle(@Param("articleId")Integer articleId);
    public Integer stickArticle(@Param("articleId")Integer articleId);
    public Integer cancelBanArticlee(@Param("articleId")Integer articleId);
    public Integer cancelStickArticle(@Param("articleId")Integer articleId);

}
