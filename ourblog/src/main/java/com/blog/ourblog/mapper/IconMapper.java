package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Icon;
import org.apache.ibatis.annotations.Param;

public interface IconMapper {
    public Integer addIcon(@Param("icon") Icon icon);
    public Integer deleteIcon(@Param("id") Integer id);
    public Integer getIdByIcon(@Param("icon")Icon icon);
}
