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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OurblogApplicationTests {
    @Autowired
    CommentService commentService;
    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void contextLoads() {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("k2 ","v2");

    }

}
