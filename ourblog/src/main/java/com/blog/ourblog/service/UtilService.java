package com.blog.ourblog.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.OutputStream;

public interface UtilService {
    public void getProfilePhoto(OutputStream os);
    public String uploadImage(MultipartHttpServletRequest multipartHttpServletRequest);
    public void getImage(OutputStream os,String imageName);
    public void showPhoto(OutputStream os,String imageName);
}
