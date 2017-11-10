package com.xhlim.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 14:30
 */
@SpringBootApplication
public class SpringBootWarApplication extends SpringBootServletInitializer {


    /**
     * 继承SpringBootServletInitializer 并重写configure，启动后访问需要添加tomcat下的文件名
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWarApplication.class, args);
    }

}
