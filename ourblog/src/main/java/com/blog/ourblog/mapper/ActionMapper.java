package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Action;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface ActionMapper {
    public Action findActionByActionId(@Param("actionId") int actionId);
    public ArrayList<Integer> findActionIdByRoleId(@Param("roleId") int roleId);
}
