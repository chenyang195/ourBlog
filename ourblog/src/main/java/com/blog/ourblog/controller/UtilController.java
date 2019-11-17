package com.blog.ourblog.controller;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.blog.ourblog.constant.Constant;
import com.blog.ourblog.entity.EditorImageInfo;
import com.blog.ourblog.entity.Pic;
import com.blog.ourblog.mapper.PicMapper;
import com.blog.ourblog.service.UtilService;
import com.blog.ourblog.util.MD5Encrypt;
import com.blog.ourblog.util.VerificationCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class UtilController {
    @Autowired
    private Constant constant;
    @Resource
    PicMapper picMapper;
    @Autowired
    UtilService utilService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/getProfilePhoto")
    public void getProfilePhoto(HttpServletResponse response){
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream( response.getOutputStream());
            utilService.getProfilePhoto(bos);
            bos.flush();
            bos.close();

        } catch (IOException e) {

            logger.error(e.getMessage());

        }


    }
    @ResponseBody
    @RequestMapping("/uploadImage")
    public String uploadImage(MultipartHttpServletRequest multipartHttpServletRequest){

       return utilService.uploadImage(multipartHttpServletRequest);

    }
    @RequestMapping("/getImage")
    public void getImage(@Param("imageName")String imageName, HttpServletResponse response){
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream( response.getOutputStream());
            utilService.getImage(bos,imageName);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());

        }


    }

    @RequestMapping("/showPhoto")
    public void showPhoto(@Param("imageName")String imageName, HttpServletResponse response){

        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream( response.getOutputStream());
            utilService.showPhoto(bos,imageName);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());

        }


    }




}
