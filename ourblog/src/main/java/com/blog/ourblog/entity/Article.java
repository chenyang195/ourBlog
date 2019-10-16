package com.blog.ourblog.entity;

import java.sql.Timestamp;

public class Article {
    private Integer articleId;
    private String userName;
    private String title;
    private String synopsis;
    private String content;
    private Timestamp updateTime;
    private Integer starNum;
    private Integer praiseNum;
    private Integer treadNum;
    private Integer hotIndex;
    private Integer finalIndex;
    private Integer isBan;
    private Integer isStick;

    public Integer getIsStick() {
        return isStick;
    }

    public void setIsStick(Integer isStick) {
        this.isStick = isStick;
    }

    public Integer getIsBan() {
        return isBan;
    }

    public void setIsBan(Integer isBan) {
        this.isBan = isBan;
    }

    public Integer getFinalIndex() {
        return finalIndex;
    }

    public void setFinalIndex(Integer finalIndex) {
        this.finalIndex = finalIndex;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getTreadNum() {
        return treadNum;
    }

    public void setTreadNum(Integer treadNum) {
        this.treadNum = treadNum;
    }

    public Integer getHotIndex() {
        return hotIndex;
    }

    public void setHotIndex(Integer hotIndex) {
        this.hotIndex = hotIndex;
    }

    public Article(String userName, String title, String synopsis, String content) {
        this.userName = userName;
        this.title = title;
        this.synopsis = synopsis;
        this.content = content;
    }

    public Article() {
    }

    public Article(Integer id, String userName, String title, String synopsis, String content, Timestamp updateTime, Integer starNum, Integer praiseNum, Integer treadNum, Integer hotIndex) {
        this.articleId = id;
        this.userName = userName;
        this.title = title;
        this.synopsis = synopsis;
        this.content = content;
        this.updateTime = updateTime;
        this.starNum = starNum;
        this.praiseNum = praiseNum;
        this.treadNum = treadNum;
        this.hotIndex = hotIndex;
    }
}
