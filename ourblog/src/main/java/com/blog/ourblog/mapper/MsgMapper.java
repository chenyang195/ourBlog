package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsgMapper {
    public Integer addMsg(@Param("msg")Msg msg);
    public List<Msg> getMsg(@Param("userName")String userName,@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize,@Param("type")Integer type,@Param("isRead")Integer isRead);

    public Integer getMsgNum(@Param("userName")String userName,@Param("type")Integer type,@Param("isRead")Integer isRead);


    public Integer readMsg(@Param("id") Integer id);
    public Integer deleteMsg(@Param("id") Integer id);

    public Msg getMsgById(@Param("id") Integer id);
    public Integer readAll(@Param("userName")String userName,@Param("type")Integer type);
    public Integer deleteAll(@Param("userName")String userName,@Param("type")Integer type,@Param("isRead")Integer isRead);


}
