package com.richur.venus.web.config;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author richur
 * @Date 2019/10/17 12:17 PM
 */
@Configuration
public class VenusDiscoveryConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(VenusDiscoveryConfig.class);

    @Value("${server.port}")
    private String port;


    public static void main(String[] args) {


    }
}
