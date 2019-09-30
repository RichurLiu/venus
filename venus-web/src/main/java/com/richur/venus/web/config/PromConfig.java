package com.richur.venus.web.config;

import io.micrometer.core.instrument.Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author richur
 * @Date 2019/9/27 10:11 AM
 */
@Configuration
public class PromConfig {

//    @Autowired
//    PrometheusMeterRegistry registry;
//
//    @Bean
//    public Counter getCounter() {
//        Counter counter = Counter.builder("test_request")
//                .tags("status", "success")
//                .description("Number of successful request")
//                .register(registry);
//        return counter;
//    }

}
