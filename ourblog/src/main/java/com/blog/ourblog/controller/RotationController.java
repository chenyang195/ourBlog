package com.blog.ourblog.controller;

import com.blog.ourblog.entity.Rotation;
import com.blog.ourblog.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RotationController {
    @Autowired
    RotationService rotationService;

    @ResponseBody
    @RequestMapping("/getRotation")
    public Map<String, List<Rotation>> getRotation(){
        Map<String, List<Rotation>> map = new HashMap<>();
        map.put("rotations",rotationService.getRotation());
        return map;
    }
}
