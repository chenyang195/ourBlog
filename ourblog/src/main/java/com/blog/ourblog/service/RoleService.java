package com.blog.ourblog.service;

import java.util.List;

public interface RoleService {
    public Integer setDefaultRole(Integer userId);
    public List<String> getActives(String username);
}
