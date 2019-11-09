package com.blog.ourblog.mapper;


import com.blog.ourblog.entity.Rotation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RotationMapper {
    public Integer addRotation(@Param("rotation")Rotation rotation);
    public List<Rotation> getRotations();
    public Integer deleteRotation(@Param("id")Integer id);
    public Integer updateRotation(@Param("rotation")Rotation rotation);
}
