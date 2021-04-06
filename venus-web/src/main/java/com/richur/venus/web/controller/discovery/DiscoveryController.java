package com.richur.venus.web.controller.discovery;

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

    //http://localhost:9002/venus/discovery
    @RequestMapping("/discovery")
    public String healthCheck(){
        LOGGER.info("OK");
        return "OK";
    }
}
