package com.blog.ourblog.mapper;


import com.blog.ourblog.entity.LoginHistory;
import com.blog.ourblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper {
    public User findByUsername(@Param("username") String username);
    public Integer insertUser(@Param("user") User user);
    public Integer flushUserLogin(@Param("location") String location,@Param("timestamp") Timestamp timestamp,@Param("username")String username);
    public Integer insertLoginHistory(@Param("loginHistory")LoginHistory loginHistory);
    public List<LoginHistory> findLoginHistoryByUserName(@Param("username") String username,@Param("pageHead")Integer pageHead,@Param("pageSize")Integer pageSize);
}
