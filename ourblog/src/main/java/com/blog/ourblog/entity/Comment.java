package com.blog.ourblog.entity;


import java.sql.Timestamp;

public class Comment {
    private Integer commentId;
    private String speaker;
    private String listener;
    private String content;
    private Timestamp createTime;
    private Integer articleId;

    public Comment(String speaker, String listener, String content, Timestamp createTime, Integer articleId) {
        this.speaker = speaker;
        this.listener = listener;
        this.content = content;
        this.createTime = createTime;
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", speaker='" + speaker + '\'' +
                ", listent='" + listener + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", articleId=" + articleId +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Comment() {
    }
}
