package com.blog.ourblog.controller;

import ch.qos.logback.core.util.FileUtil;
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
    public Object upLoad(MultipartHttpServletRequest multipartHttpServletRequest){

        // 图片存储路径
        String path = constant.getSource();
        // 返回值
        HashMap map = new HashMap();
        List<String> data = new ArrayList<>();
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
                    map.put("errno", 0);
                    map.put("data", pic.getSrc());


                    return map;
                }


                // 文件名
                String fileName = multipartFile.getOriginalFilename();
                // 获取文件拓展名
                String extName = fileName.substring(fileName.lastIndexOf("."));

                if (null==extName) {
                    logger.error("文件后缀名称为空，文件可能有问题...");
                    map.put("errno", 1);
                    map.put("data", data);
                    return map;
                }
                Subject subject = SecurityUtils.getSubject();
                String username = subject.getPrincipal().toString();
                String newFileName = UUID.randomUUID().toString().replaceAll("\\-", "")+extName;
                logger.info(username+"上传了"+newFileName);
                // 保证 文件夹存
                File fileDir = new File(path);
                if (!fileDir.exists()){
                    fileDir.mkdirs();
                }
                File file = new File(fileDir, newFileName);
                // 拷贝文件流  到上面的文件
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    logger.error(e.getMessage());
                    logger.error("无法写出");
                    map.put("errno", 1);
                    map.put("data", data);
                    return map;
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


        return map;

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
