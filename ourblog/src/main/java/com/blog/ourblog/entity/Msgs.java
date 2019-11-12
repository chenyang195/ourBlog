package com.blog.ourblog.entity;

import java.util.List;

public class Msgs {
    private  List<Msg> msgList;
    private Integer msgNum;

    @Override
    public String toString() {
        return "Msgs{" +
                "msgList=" + msgList +
                ", msgNum=" + msgNum +
                '}';
    }

    public List<Msg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
    }

    public Integer getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(Integer msgNum) {
        this.msgNum = msgNum;
    }

    public Msgs() {
    }
}
