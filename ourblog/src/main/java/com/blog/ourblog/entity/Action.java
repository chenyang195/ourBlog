package com.blog.ourblog.entity;

public class Action {
    private Integer actionId;
    private String actionName;

    public Action(Integer actionId, String actionName) {
        this.actionId = actionId;
        this.actionName = actionName;
    }

    public Action(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", actionName='" + actionName + '\'' +
                '}';
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Action() {
    }
}
