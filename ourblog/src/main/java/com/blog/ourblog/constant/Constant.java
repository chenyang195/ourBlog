package com.blog.ourblog.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "pic")
@PropertySource("classpath:constant.properties")
public class Constant {
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
