package com.richur.venus.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @SpringBootApplication 标记spring boot项目启动项
 */
@ComponentScan(basePackages = {"com.richur.venus"})
//@ComponentScan(basePackages = {"com.richur.venus","com.bilibili.naming"})
@SpringBootApplication
//@EnableDiscoveryNamingClient
public class VenusWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenusWebApplication.class, args);
    }

}
