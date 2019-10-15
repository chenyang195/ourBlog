package com.blog.ourblog.entity;

import java.util.List;
import java.util.Map;

public class Page {
    Integer stickNum;
    Integer articleNum;
    Map<String, List<Article>> articleMap;

    public Page() {
    }

    public Page(Integer stickNum, Integer articleNum, Map<String, List<Article>> articleMap) {
        this.stickNum = stickNum;
        this.articleNum = articleNum;
        this.articleMap = articleMap;
    }

    @Override
    public String toString() {
        return "Page{" +
                "stickNum=" + stickNum +
                ", articleNum=" + articleNum +
                ", articleMap=" + articleMap +
                '}';
    }

    public Integer getStickNum() {
        return stickNum;
    }

    public void setStickNum(Integer stickNum) {
        this.stickNum = stickNum;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Map<String, List<Article>> getArticleMap() {
        return articleMap;
    }

    public void setArticleMap(Map<String, List<Article>> articleMap) {
        this.articleMap = articleMap;
    }
}
