package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Role;
import com.blog.ourblog.entity.User;
import com.blog.ourblog.mapper.ActionMapper;
import com.blog.ourblog.mapper.RoleMapper;
import com.blog.ourblog.mapper.UserMapper;
import com.blog.ourblog.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceimpl implements RoleService {
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    ActionMapper actionMapper;

    @Override
    public Integer setDefaultRole(Integer userId) {
        Integer result = -1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result =roleMapper.setRole(userId,list);

        return result;
    }

    @Override
    public List<String> getActives(String username) {
        Role role;
        List<String> list = new ArrayList<>();
        User user = userMapper.findByUsername(username);
        List<Integer> roleIds = roleMapper.findRoleIdByUserId(user.getId());

        for (Integer roleId:roleIds){
            role = roleMapper.findRoleByRoleId(roleId);
            List<Integer> actionIds = actionMapper.findActionIdByRoleId(roleId);
            for (Integer acyionId:actionIds) {
                list.add(role.getName()+":"
                        +actionMapper.findActionByActionId(acyionId).getActionName());
            }

        }


        return list;
    }

}
