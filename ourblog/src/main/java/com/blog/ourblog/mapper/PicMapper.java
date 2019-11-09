package com.blog.ourblog.mapper;

import com.blog.ourblog.entity.Pic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PicMapper {
    public Integer addPic(@Param("pic")Pic pic);
    public Pic getPic(@Param("md5")String md5);
}
