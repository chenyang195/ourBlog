package com.blog.ourblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.ourblog.service.IPService;
import com.blog.ourblog.util.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IPServiceimpl implements IPService {

    @Override
    public String getLocation(String ip) {
        String location = null;

        String host = "http://iploc.market.alicloudapi.com";
        String path = "/v3/ip";
        String method = "GET";
        String appcode = "97ed093b5de74c56bf41e2449dd06481";
        Map<String, String> headers = new HashMap<>();

        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip", ip);


        try {

            HttpResponse response =  HttpUtils.doGet(host, path, method, headers, querys);
            HttpEntity httpEntity = response.getEntity();
            String entityString = EntityUtils.toString(httpEntity);
            JSONObject object = JSON.parseObject(entityString);
            location =object.getString("province")+"-"+object.getString("city");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
}
