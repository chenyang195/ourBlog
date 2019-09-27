package com.blog.ourblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blog.ourblog.mapper")
public class OurblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurblogApplication.class, args);
    }

}
