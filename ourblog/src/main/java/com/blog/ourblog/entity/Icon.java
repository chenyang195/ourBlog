package com.blog.ourblog.entity;

import java.sql.Timestamp;

public class Icon {
    Integer id;
    Integer articleId;
    String userName;
    Integer type;
    Timestamp createTime;

    @Override
    public String toString() {
        return "Icon{" +
                "id=" + id +
                ", articleId='" + articleId + '\'' +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Icon() {
    }
}
