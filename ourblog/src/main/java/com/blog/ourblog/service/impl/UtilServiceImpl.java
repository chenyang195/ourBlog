package com.blog.ourblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.blog.ourblog.constant.Constant;
import com.blog.ourblog.entity.Pic;
import com.blog.ourblog.entity.User;
import com.blog.ourblog.mapper.PicMapper;
import com.blog.ourblog.mapper.UserMapper;
import com.blog.ourblog.service.UtilService;
import com.blog.ourblog.util.ImageToIO;
import com.blog.ourblog.util.MD5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.net.www.content.image.jpeg;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private Constant constant;
    @Resource
    UserMapper userMapper;
    @Resource
    PicMapper picMapper;
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
    public String uploadImage(MultipartHttpServletRequest multipartHttpServletRequest) {
            Map<String,Object> map = new HashMap<>();
            List<String> data = new ArrayList<>();

        Object principal = SecurityUtils.getSubject().getPrincipal();
        if (principal==null){
                map.put("errno", 1);
                map.put("data", data);
                return JSON.toJSONString(map);
            }
            Logger logger = LoggerFactory.getLogger(getClass());

            // 图片存储路径
            //String path = constant.getSource();
            // 返回值


            // 取得request中的所有文件名
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            // 遍历
            while (iterator.hasNext()) {
                // 取得上传文件
                MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
                if (multipartFile != null) {
                    String md5 = MD5Encrypt.getMd5(multipartFile);
                    Pic pic = picMapper.getPic(md5);
                    if (pic!=null){
                        data.add(pic.getSrc());
                        map.put("errno", 0);

                        map.put("data", data);


                        return JSON.toJSONString(map);
                    }


                    // 文件名
                    String fileName = multipartFile.getOriginalFilename();
                    // 获取文件拓展名
                    String extName = fileName.substring(fileName.lastIndexOf("."));

                    if (null==extName) {
                        logger.error("文件后缀名称为空，文件可能有问题...");
                        map.put("errno", 1);
                        map.put("data", data);
                        return JSON.toJSONString(map);
                    }

                    String username = principal.toString();
                    String newFileName = UUID.randomUUID().toString().replaceAll("\\-", "")+extName;
                    logger.info(username+"上传了"+newFileName);
                    // 保证 文件夹存
                    File fileDir = new File("/home/ubuntu/picDB/image");
                    if (!fileDir.exists()){
                        fileDir.mkdirs();
                    }
                    File file = new File(fileDir, newFileName);
                    // 拷贝文件流  到上面的文件
                    try {
                        multipartFile.transferTo(file);
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                        logger.error("无法写入文件到硬盘中！");
                        map.put("errno", 1);
                        map.put("data", data);
                        return JSON.toJSONString(map);
                    }
                    // 构建图片的可访问地址
                    String webUrl = "/getImage?imageName=" + newFileName;
                    pic = new Pic();
                    pic.setMd5(md5);
                    pic.setSrc(webUrl);
                    picMapper.addPic(pic);

                    logger.info("文件路径： {}", webUrl );
                    // 添加到数组中
                    data.add(webUrl);
                }
            }
            // 返回前端需要的格式
            map.put("errno", 0);
            map.put("data", data);


        return JSON.toJSONString(map);


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
