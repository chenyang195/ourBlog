package com.blog.ourblog.entity;


import java.sql.Timestamp;

public class LoginHistory {
    Integer id;
    String userName;
    String IP;
    String location;
    Timestamp time;

    public LoginHistory() {
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", IP='" + IP + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
