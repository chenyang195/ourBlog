package com.blog.ourblog.service.impl;

import com.blog.ourblog.entity.Msg;
import com.blog.ourblog.entity.Msgs;
import com.blog.ourblog.mapper.MsgMapper;
import com.blog.ourblog.service.MsgService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService {
    @Resource
    MsgMapper msgMapper;
    @Override
    public Msgs getMsgs(Integer pageNum, Integer type, Integer isRead) {
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        if (userName==null){
            return null;
        }
        Integer pageHead = (pageNum-1)*10;
        Msgs msgs = new Msgs();
        msgs.setMsgList(msgMapper.getMsg(userName,pageHead,10,type,isRead));
        msgs.setMsgNum(msgMapper.getMsgNum(userName,type,isRead));

        return msgs;
    }



    @Override
    public Integer sendMsg(String listener,Integer type,String content) {

        String sendBy = SecurityUtils.getSubject().getPrincipal().toString();
        if (sendBy==null&&type!=1){
            return -1;
        }
        if (sendBy.equals(listener)&&type!=1){
            return 3;
        }
        Msg msg = new Msg();
        msg.setListener(listener);
        msg.setSendBy(sendBy);
        msg.setType(type);
        msg.setContent(content);
        msg.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        System.out.println(msg);
        msgMapper.addMsg(msg);
        if(msg.getId()==null){
            msg.setId(-1);
        }
        return msg.getId();
    }

    @Override
    public Map<String, Integer> getUserMsgInfo() {
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        if (userName ==null){
            return null;
        }
        Map<String,Integer> msgInfo = new HashMap<>();
        Integer sysNum = msgMapper.getMsgNum(userName,1,0);

        if (sysNum==null){
            msgInfo.put("sysNum",0);
        }else {
            msgInfo.put("sysNum",sysNum);
        }
        Integer replyNum = msgMapper.getMsgNum(userName,2,0);

        if (replyNum==null){
            msgInfo.put("replyNum",0);
        }else {
            msgInfo.put("replyNum",replyNum);
        }
        Integer personalNum = msgMapper.getMsgNum(userName,3,0);

        if (personalNum==null){
            msgInfo.put("personalNum",0);
        }else {
            msgInfo.put("personalNum",personalNum);
        }
        return msgInfo;
    }

    @Override
    public Integer deleteMsg(Integer id) {
        if (id <0){
            return -1;
        }
        return msgMapper.deleteMsg(id);
    }

    @Override
    public Integer readMsg(Integer id) {
        if (id <0){
            return -1;
        }
        return msgMapper.readMsg(id);
    }

    @Override
    public Msg getMsgById(Integer id) {
        if (id <0){
            return null;
        }
        return msgMapper.getMsgById(id);
    }

    @Override
    public Integer readAll(Integer type) {
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        if (userName ==null){
            return null;
        }
        Integer res = msgMapper.readAll(userName,type);
        return res;
    }

    @Override
    public Integer deleteAll(Integer type, Integer isRead) {
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        if (userName ==null){
            return null;
        }
        Integer res = msgMapper.deleteAll(userName,type,isRead);
        return res;
    }
}
