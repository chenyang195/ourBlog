package com.blog.ourblog.entity;
import java.util.List;

public class ArticleInfos {
    Integer ArticleNum;
    List<Article> articleList;

    @Override
    public String toString() {
        return "ArticleInfos{" +
                "ArticleNum=" + ArticleNum +
                ", articleList=" + articleList +
                '}';
    }

    public Integer getArticleNum() {
        return ArticleNum;
    }

    public void setArticleNum(Integer articleNum) {
        ArticleNum = articleNum;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleInfos() {
    }
}
