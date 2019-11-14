package com.blog.ourblog.service.impl;

import com.blog.ourblog.constant.Constant;
import com.blog.ourblog.entity.User;
import com.blog.ourblog.mapper.UserMapper;
import com.blog.ourblog.service.UtilService;
import com.blog.ourblog.util.ImageToIO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.net.www.content.image.jpeg;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private Constant constant;
    @Resource
    UserMapper userMapper;
    @Override
    public void getProfilePhoto(OutputStream os) {
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        User user = userMapper.findByUsername(username);
        String path = user.getImageURL();
        try {
            ImageToIO.getIO(path,os);
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());
        }
    }

    @Override
    public String uploadImage(MultipartFile file) {
        Logger logger = LoggerFactory.getLogger(getClass());

        //本地使用,上传位置
        //String rootPath = constant.getSource();

        String filename = file.getOriginalFilename();

        //文件后缀,如.jpeg
        String suffix = filename.substring(filename.lastIndexOf("."));

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replaceAll("\\-", "");
        String newFilename = uuidStr+suffix;
        //目标文件
        File descFile = new File("/home/ubuntu/picDB/image/"  + newFilename);
        try {
            file.transferTo(descFile);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传失败，cause:{}", e);
        }
        //完整的url
        String fileUrl = "http://localhost/getImage？imageName=" + newFilename;

        return fileUrl;
    }

    @Override
    public void getImage(OutputStream os, String imageName) {
        String path = "picDB/image/"+imageName;
        try {
            ImageToIO.getIO(path,os);
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());
        }

    }

    @Override
    public void showPhoto(OutputStream os, String imageName) {
        String path = "picDB/image/"+imageName;

        try {
            ImageToIO.getIO(path,os);
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());
        }
    }

}
