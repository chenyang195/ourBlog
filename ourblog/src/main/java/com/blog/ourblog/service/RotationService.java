package com.blog.ourblog.service;

import com.blog.ourblog.entity.Rotation;

import java.util.List;

public interface RotationService {
    public List<Rotation> getRotation();
    public Integer addRotation(Rotation rotation);
    public Integer deleteRotation(Integer id);
    public Integer updateRotation(Rotation rotation);
}
