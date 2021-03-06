package com.blog.ourblog.entity;

public class EditorImageInfo {
    private Integer errno;
    private String[] data;

    public EditorImageInfo(Integer errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public EditorImageInfo() {
    }
}
