package com.blog.ourblog.entity;

public class Pic {
    String md5;
    String src;

    @Override
    public String toString() {
        return "Pic{" +
                "md5='" + md5 + '\'' +
                ", src='" + src + '\'' +
                '}';
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Pic() {
    }
}
