package com.blog.ourblog.entity;

import java.sql.Timestamp;

public class Msg {
    Integer id;
    String listener;
    Timestamp createTime;
    String content;
    Integer isRead;
    Integer type;
    String sendBy;

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", listener='" + listener + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", type=" + type +
                ", sendBy='" + sendBy + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public Msg() {
    }
}
