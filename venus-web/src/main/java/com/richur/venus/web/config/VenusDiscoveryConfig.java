package com.richur.venus.web.config;

import com.bilibili.naming.NamingClient;
import com.bilibili.naming.bean.Application;
import com.bilibili.naming.bean.InstanceInfo;
import com.bilibili.naming.protocol.discovery.DiscoveryNamingClientImpl;
import com.bilibili.naming.protocol.discovery.DiscoveryTransportFactory;
import com.bilibili.naming.protocol.discovery.config.DiscoveryConfig;
import com.bilibili.naming.protocol.discovery.impl.DiscoveryTransportFactoryImpl;
import com.bilibili.naming.protocol.discovery.springboot.DiscoverySelfConfigProperties;
import com.bilibili.naming.protocol.discovery.transport.DiscoveryPollClient;
import com.bilibili.naming.protocol.discovery.transport.impl.DiscoveryPollClientImpl;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    //@Bean
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


    public static void main(String[] args) {
        /*archer.executenode.discovery.dependency.app.ids=datacenter.dispatcher
        archer.executenode.discovery.node.service.url=http://uat-discovery.bilibili.co
        archer.executenode.discovery.server.app.id=datacenter.dispatcher
        archer.executenode.discovery.server.env=uat
        archer.executenode.discovery.server.region=sh
        archer.executenode.discovery.server.zone=sh001
        archer.executenode.discovery.server.version=1.0.0*/
        DiscoveryConfig discoveryConfig = new DiscoveryConfig();
        List<String> dependencyAppIds = new ArrayList<>();
        dependencyAppIds.add("datacenter.dispatcher");
        discoveryConfig.setDependencyAppIds(dependencyAppIds);
        discoveryConfig.setNodeServiceUrl("http://uat-discovery.bilibili.co");
        discoveryConfig.setPollReadTimeout(50000L);

        InstanceInfo instanceInfo = new InstanceInfo();
        String dispatcherAppId = "datacenter.dispatcher";
        instanceInfo.setAppId(dispatcherAppId);
        instanceInfo.setEnv("uat");
        instanceInfo.setRegion("sh");
        instanceInfo.setZone("sh001");
        instanceInfo.setVersion("1.0.0");

        String hostname = "localhost";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOGGER.warn("get hostname error", e);
        }
        instanceInfo.setHostName(hostname);
        LOGGER.info("discoveryConfig: {}", instanceInfo);

        discoveryConfig.setInstanceConf(instanceInfo);
        DiscoveryTransportFactory discoveryTransportFactory = new DiscoveryTransportFactoryImpl(
                discoveryConfig);

        DiscoveryPollClient discoveryPollClient = new DiscoveryPollClientImpl(
                discoveryTransportFactory);
        NamingClient namingClient = new DiscoveryNamingClientImpl(discoveryPollClient,
                discoveryTransportFactory, discoveryConfig);


        Application application = namingClient.getApplication("datacenter.dispatcher");
        if (null == application || application.getInstances() == null
                || application.getInstances().size() == 0) {
            return;
        }
        List<InstanceInfo> instanceInfoList = application.getInstances();
        System.out.println(instanceInfoList);

        List<InstanceInfo> instanceClusterList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(instanceInfoList)){
            instanceInfoList.forEach(instance ->{
                Map<String, Object> metadata = instance.getMetadata();
                if("".equals(metadata.get("cluster"))) {
                    instanceClusterList.add(instance);
                    List<String> addrs = instance.getAddrs();
                    for (String addr : addrs) {
                        if(addr.startsWith("grpc")){
                            System.out.println(addr);
                        }
                    }
                }
            });
        }
        System.out.println(instanceClusterList);

    }
}
