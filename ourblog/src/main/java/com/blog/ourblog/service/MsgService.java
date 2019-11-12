package com.blog.ourblog.service;

import com.blog.ourblog.entity.Msg;
import com.blog.ourblog.entity.Msgs;

import java.util.Map;

public interface MsgService {
    public Msgs getMsgs(Integer pageNum,Integer type,Integer isRead);
    public Integer sendMsg(String listener,Integer type,String content);
    public Map<String,Integer> getUserMsgInfo();
    public Integer deleteMsg(Integer id);
    public Integer readMsg(Integer id);
    public Msg getMsgById(Integer id);
    public Integer readAll(Integer type);
    public Integer deleteAll(Integer type,Integer isRead);

}
