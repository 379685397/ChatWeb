package com.chatweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = {"com.chatweb"})
//注册过滤器注解
@MapperScan({"com.*.mapper"})
public class ChatWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ChatWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatWebApplication.class, args);
    }

}