package com.richur.venus.web.config;

import com.bilibili.naming.protocol.discovery.springboot.DiscoverySelfConfigProperties;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Author richur
 * @Date 2019/10/17 12:17 PM
 */
@Configuration
public class VenusDiscoveryConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(VenusDiscoveryConfig.class);

    @Value("${server.port}")
    private String port;

    @Bean
    public DiscoverySelfConfigProperties discoverySelfConfigProperties() throws UnknownHostException {
        DiscoverySelfConfigProperties selfConfigProperties = new DiscoverySelfConfigProperties();
        selfConfigProperties.setAppId("datacenter.abserver-service.abserver-service");
        selfConfigProperties.setEnv("uat");
        selfConfigProperties.setRegion("sh");
        selfConfigProperties.setZone("sh001");
        selfConfigProperties.setVersion("1.0.0");

        InetAddress localhost = InetAddress.getLocalHost();
        selfConfigProperties.setHostName(localhost.getHostName());
        selfConfigProperties.setAddrs(Lists.newArrayList("http://", localhost.getHostName(), ":", port));
        selfConfigProperties.setAddrs(Arrays.asList("http://" + localhost.getHostName() + ":" + port));
        LOGGER.info("====================: http://" + localhost.getHostName() + ":" + port);
        return selfConfigProperties;
    }
}
