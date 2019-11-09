package com.blog.ourblog;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.ourblog.service.CommentService;
import com.blog.ourblog.service.IPService;
import com.blog.ourblog.util.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OurblogApplicationTests {
    @Autowired
    CommentService commentService;


    @Test
    public void contextLoads() {
        System.out.println(commentService.getComments(23,1,10));

    }

}
