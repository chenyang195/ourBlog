package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
;

import java.util.List;
@Mapper
public interface CommentMapper {
    public Integer addComment(@Param("comment")Comment comment);
    public List<Comment> getCommentByArticleId(@Param("articleId")Integer articleId,@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
    public Comment getCommentByCommentId(@Param("commentId")Integer commentId);
    public Integer countComments(@Param("articleId")Integer articleId);
}
