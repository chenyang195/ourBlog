package com.blog.ourblog.mapper;


import com.blog.ourblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findByUsername(@Param("username") String username);
    public Integer insertUser(@Param("user") User user);
}
