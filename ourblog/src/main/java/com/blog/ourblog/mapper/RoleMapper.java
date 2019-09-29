package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
@Mapper
public interface RoleMapper {
    public Role findRoleByRoleId(@Param("roleId") int roleId);
    public ArrayList<Integer>findRoleIdByUserId(@Param("userId") int userId);
}
