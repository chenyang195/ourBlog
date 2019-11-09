package com.blog.ourblog.entity;

public class Rotation {
    private Integer id;
    private String imageSrc;
    private String hyperlink;

    @Override
    public String toString() {
        return "Rotation{" +
                "id=" + id +
                ", imageSrc='" + imageSrc + '\'' +
                ", hyperlink='" + hyperlink + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public Rotation() {
    }
}
