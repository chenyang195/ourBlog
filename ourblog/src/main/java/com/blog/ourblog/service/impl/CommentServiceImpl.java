package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Comment;
import com.blog.ourblog.entity.Comments;
import com.blog.ourblog.mapper.CommentMapper;
import com.blog.ourblog.service.CommentService;
import org.apache.shiro.SecurityUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;

    @Override
    public Integer addComment(Comment comment) {
        String userName = null;

        if (SecurityUtils.getSubject().getPrincipal()==null){
            userName = "一位没有注册的游客";
        }else {
            userName =SecurityUtils.getSubject().getPrincipal().toString();
        }
        comment.setSpeaker(userName);
        comment.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));


        commentMapper.addComment(comment);
        /*if(comment.getCommentId()==null){
            System.out.println(getClass().toString()+"添加失败");
        }*/

        return null;
    }

    @Override
    public Comments getComments(Integer articleId, Integer pageHead, Integer pageSize) {
        Comments comments = new Comments();
        comments.setCommentNum(commentMapper.countComments(articleId));
        comments.setComments(commentMapper.getCommentByArticleId(articleId,pageHead,pageSize));
        return comments;
    }
}
