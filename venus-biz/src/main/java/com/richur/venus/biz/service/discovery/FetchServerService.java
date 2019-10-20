package com.richur.venus.biz.service.discovery;

import com.bilibili.naming.protocol.discovery.springboot.DiscoverySelfConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bilibili.naming.NamingClient;
import com.bilibili.naming.bean.Application;
import com.bilibili.naming.bean.InstanceInfo;

/**
 * @Author richur
 * @Date 2019/10/17 6:05 PM
 */
@Component
public class FetchServerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchServerService.class);

    @Autowired
    private NamingClient namingClient;

    private Application application;

    public FetchServerService(){

        if(namingClient == null){
            LOGGER.info("=======namingClient is null======");
        }
//        application = namingClient.getApplication("datacenter.dispatcher");
//        InstanceInfo instanceInfo = application.getInstances().get(0);
//        String[] addr = instanceInfo.getAddrs().get(0).split(":");
//        this.channel = ManagedChannelBuilder.forAddress(addr[0], Integer.parseInt(addr[1])).usePlaintext().build();
//        blockingStub = DispatcherServerGrpc.newBlockingStub(channel);
//        stub = DispatcherServerGrpc.newStub(channel);
    }




    public Application getApplication(){

        if(null == namingClient){
            LOGGER.info("error...");
            return application;
        }
        application = namingClient.getApplication("datacenter.abserver-service.abserver-service");
        return application;
    }


    public String getTest(){

        LOGGER.info("test ok");
        return "test ok";
    }


}
