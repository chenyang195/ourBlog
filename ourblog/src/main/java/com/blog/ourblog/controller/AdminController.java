package com.blog.ourblog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.ourblog.entity.Article;
import com.blog.ourblog.entity.ArticleInfos;
import com.blog.ourblog.entity.Rotation;
import com.blog.ourblog.mapper.ArticleMapper;
import com.blog.ourblog.service.ArticleService;
import com.blog.ourblog.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    ArticleService articleService;

    @Autowired
    RotationService rotationService;
    @Resource
    ArticleMapper articleMapper;

    @ResponseBody
    @RequestMapping("/reviseRotation")
    public String reviseRotation(@RequestParam("imageURL")String imageURL,@RequestParam("id")String id,@RequestParam("hyperlink")String hyperlink){
        id=id.trim();
        if(imageURL.equals("unknow")||hyperlink.equals("unknow")){
            return "-1";
        }
        if(id.equals("unknow")){
            Rotation rotation=new Rotation();
            rotation.setHyperlink(hyperlink);
            rotation.setImageSrc(imageURL);
            Integer res =rotationService.addRotation(rotation);
            return res.toString();
        }
        Rotation rotation=new Rotation();
        rotation.setHyperlink(hyperlink);
        rotation.setImageSrc(imageURL);
        rotation.setId(Integer.parseInt(id));
        Integer res =rotationService.updateRotation(rotation);
        return res.toString();

    }
    @ResponseBody
    @RequestMapping("/deleteRotation")
    public String deleteRotation(@RequestParam("id")String id){
        if(id.equals("unknow")){
            return "-1";
        }
        Integer res =rotationService.deleteRotation(Integer.parseInt(id.trim()));
        return res.toString();
    }
    @ResponseBody
    @RequestMapping("/removeStick")
    public String removeStick(@RequestParam("id")String id){

        Integer intId = Integer.parseInt(id.trim());
        if(intId>0){
           Integer res =  articleMapper.cancelStickArticle(intId);
           return res.toString();
        }

        return "-1";
    }
    @ResponseBody
    @RequestMapping("/stickArt")
    public String stickArt(@RequestParam("id")String id){

        Integer intId = Integer.parseInt(id.trim());
        if(intId>0){
            Integer res =  articleMapper.stickArticle(intId);
            return res.toString();
        }

        return "-1";
    }
    @ResponseBody
    @RequestMapping("/banArt")
    public String banArt(@RequestParam("id")String id){

        Integer intId = Integer.parseInt(id.trim());
        if(intId>0){
            Integer res =  articleMapper.banArticle(intId);
            articleMapper.cancelStickArticle(intId);
            return res.toString();
        }

        return "-1";
    }

    @ResponseBody
    @RequestMapping("/getBan")
    public String getNew(@RequestParam("pageNum")String pageNum){
        Integer pageHead = (Integer.parseInt(pageNum)-1)*10;
        if (pageHead.intValue()<0){

            pageHead = 0;
        }
        ArticleInfos articleInfos = new ArticleInfos();
        articleInfos.setArticleNum(articleMapper.getBanArticleNumber());
        articleInfos.setArticleList(articleService.getBan(pageHead,10));
        return JSON.toJSON(articleInfos).toString();
    }

    @ResponseBody
    @RequestMapping("/removeBan")
    public String removeBan(@RequestParam("id")String id){

        Integer intId = Integer.parseInt(id.trim());
        if(intId>0){
            Integer res =  articleMapper.cancelBanArticle(intId);

            return res.toString();
        }

        return "-1";
    }
}
