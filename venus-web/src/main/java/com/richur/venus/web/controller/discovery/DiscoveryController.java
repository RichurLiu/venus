package com.richur.venus.web.controller.discovery;

import com.alibaba.fastjson.JSON;
import com.bilibili.naming.NamingClient;
import com.bilibili.naming.bean.Application;
import com.richur.venus.biz.service.discovery.FetchServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author richur
 * @Date 2019/10/17 6:08 PM
 */
@RestController
@RequestMapping("/venus")
public class DiscoveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryController.class);


    @Autowired
    private FetchServerService fetchServerService;
    private NamingClient namingClient;


//    @Autowired
//    public DiscoveryController(FetchServerService fetchServerService, NamingClient namingClient) {
//        this.fetchServerService = fetchServerService;
//        this.namingClient = namingClient;
//    }
//http://localhost:9002/venus/discovery
    @RequestMapping("/discovery")
    public String healthCheck(){
        LOGGER.info("OK");
//        Application application = namingClient.getApplication("datacenter.abserver-service.abserver-service");
        Application application = fetchServerService.getApplication();
        return JSON.toJSONString(application);
    }
}
