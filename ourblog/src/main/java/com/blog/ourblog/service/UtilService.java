package com.blog.ourblog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface UtilService {
    public void getProfilePhoto(OutputStream os);
    public String uploadImage(MultipartFile file);
    public void getImage(OutputStream os,String imageName);
}
