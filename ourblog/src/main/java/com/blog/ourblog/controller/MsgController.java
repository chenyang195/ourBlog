package com.blog.ourblog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.ourblog.entity.Msgs;
import com.blog.ourblog.service.MsgService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MsgController {
    @Autowired
    MsgService msgService;
    @ResponseBody
    @RequestMapping("/getMsgInfo")
    public String getMsgInfo(){
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        if (name==null){
            return null;
        }
        Map<String,Integer> msgInfo ;
        msgInfo = msgService.getUserMsgInfo();


        return JSON.toJSONString(msgInfo);
    }
    @ResponseBody
    @RequestMapping("/getMsgs")
    protected String getMsgs(@RequestParam("type")String type,@RequestParam("isRead")String isRead,@RequestParam("pageNum")String pageNum){
        Msgs msgs = new Msgs();
        msgs = msgService.getMsgs(Integer.parseInt(pageNum.trim()),Integer.parseInt(type.trim()),Integer.parseInt(isRead.trim()));
        return JSON.toJSONString(msgs);

    }
    @ResponseBody
    @RequestMapping("/readMsg")
    public String readMsg(@Param("id")String id){
        Integer res = msgService.readMsg(Integer.parseInt(id.trim()));

        return res.toString();
    }
    @ResponseBody
    @RequestMapping("/readAll")
    public String readAll(@Param("type")String type){
        Integer res = msgService.readAll(Integer.parseInt(type.trim()));
        return res.toString();
    }

    @ResponseBody
    @RequestMapping("/deleteAll")
    public String deleteAll(@Param("type")String type,@Param("isRean")String isRead){
        Integer res = msgService.deleteAll(Integer.parseInt(type.trim()),Integer.parseInt(isRead.trim()));
        return res.toString();
    }
    @ResponseBody
    @RequestMapping("/sendLetter")
    public String sendLetter(@Param("content")String content,@Param("listener")String listener){
        Integer integer = msgService.sendMsg(listener.trim(),3,content.trim());
        if(integer==3){
            return "3";
        }

        if (integer>0){
            return "1";
        }

        return "2";
    }

}
