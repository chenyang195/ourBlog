package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public Integer addArticle(@Param("article") Article article);
    public Article getArticleInformation(@Param("articleId")Integer articleId);
    public Integer getArticleNumber();
    public Article getArticle(@Param("articleId")Integer articleId);
    public List<Article> getStickArticleInformation();
    public Integer getStickArticleNumber();
    public List<Article> getHotArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public List<Article> getNewArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Integer getBanArticleNumber();
    public List<Article> getBanArticleInformation(@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Integer updateArticle(@Param("article") Article article);
    public Integer banArticle(@Param("articleId")Integer articleId);
    public Integer stickArticle(@Param("articleId")Integer articleId);
    public Integer cancelBanArticle(@Param("articleId")Integer articleId);
    public Integer cancelStickArticle(@Param("articleId")Integer articleId);
    public Integer draftArticle(@Param("articleId")Integer articleId);
    public Integer updateArticleInformation(@Param("article") Article article);

}
