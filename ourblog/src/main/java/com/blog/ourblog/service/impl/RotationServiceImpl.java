package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Rotation;
import com.blog.ourblog.mapper.RotationMapper;
import com.blog.ourblog.service.RotationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RotationServiceImpl implements RotationService {
    @Resource
    RotationMapper rotationMapper;
    @Override
    public List<Rotation> getRotation() {
        List rotations =rotationMapper.getRotations();
        return rotations;
    }

    @Override
    public Integer addRotation(Rotation rotation) {
        rotationMapper.addRotation(rotation);
        return rotation.getId();
    }

    @Override
    public Integer deleteRotation(Integer id) {
        Integer result = rotationMapper.deleteRotation(id);
        return result;
    }

    @Override
    public Integer updateRotation(Rotation rotation) {
        Integer result = rotationMapper.updateRotation(rotation);
        return result;
    }
}
