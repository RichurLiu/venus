package com.richur.venus.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication 标记spring boot项目启动项
 */
@ComponentScan(value = "com.richur.venus")
@SpringBootApplication
public class VenusWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenusWebApplication.class, args);
    }

}
