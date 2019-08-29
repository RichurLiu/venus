package com.richur.venus.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author richur
 * @Date 2019/8/27 8:12 PM
 */
@Configuration
@PropertySource(value = {"classpath:mysql.properties"})
@ConfigurationProperties(prefix = "web.config")
@Setter
@Getter
public class WebConfig {

    private String userName;
    private String password;
    private Integer gender;
    private Boolean rich;

}
