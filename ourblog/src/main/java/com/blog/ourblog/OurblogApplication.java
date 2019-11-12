package com.blog.ourblog;

import com.blog.ourblog.constant.Constant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(Constant.class)
@SpringBootApplication
@MapperScan("com.blog.ourblog.mapper")
public class OurblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurblogApplication.class, args);
    }

}
