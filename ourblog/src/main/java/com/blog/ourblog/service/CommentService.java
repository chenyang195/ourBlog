package com.blog.ourblog.service;

import com.blog.ourblog.entity.Comment;
import com.blog.ourblog.entity.Comments;

public interface CommentService {
    public Integer addComment(Comment comment);
    public Comments getComments(Integer articleId,Integer pageHead,Integer pageSize);
}
