package com.blog.ourblog.entity;

import java.util.List;

public class Comments {
    Integer commentNum;
    List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentNum=" + commentNum +
                ", comments=" + comments +
                '}';
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}
