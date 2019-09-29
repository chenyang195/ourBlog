package com.blog.ourblog.entity;

public class Role {
    private Integer roleId;
    private String roleName;

    public Role(Integer id, String name) {
        this.roleId = id;
        this.roleName = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", name='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return roleId;
    }

    public void setId(Integer id) {
        this.roleId = id;
    }

    public String getName() {
        return roleName;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

    public Role() {
    }
}
