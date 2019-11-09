package com.blog.ourblog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.ourblog.entity.Comment;
import com.blog.ourblog.entity.Comments;
import com.blog.ourblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/pushComment")
    public String pushComment(@RequestParam("name1")String name1,@RequestParam("comment")String comment,@RequestParam("articleId")String articleId){
        Comment comment1 = new Comment();
        comment1.setArticleId(Integer.parseInt(articleId));
        comment1.setContent(comment);
        comment1.setListener(name1);
        commentService.addComment(comment1);
        return "1";

    }
    @ResponseBody
    @RequestMapping("/getComments")
    public String getHomePage(@RequestParam("articleId")String articleId,@RequestParam("pageNum")String pageNum){
        Integer pageHead = (Integer.parseInt(pageNum)-1)*10;
        if (pageHead.intValue()<0){

            pageHead = 0;
        }
        Comments comments = commentService.getComments(Integer.parseInt(articleId),pageHead,10);
        return JSON.toJSON(comments).toString();
    }
}
