package com.richur.venus.web.controller;

import com.richur.venus.biz.util.ThreadFactoryUtils;
import com.richur.venus.web.query.TestQuery;
import io.prometheus.client.exporter.common.TextFormat;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Clock;
import java.util.concurrent.ExecutorService;

/**
 * @Author richur
 * @Date 2019/9/20 2:07 PM
 */
@RestController
@RequestMapping("/venus")
@Slf4j
public class HealthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @RequestMapping("/health")
    public String healthCheck(){
        log.info("get health-1111=====11111");
        return "OK";
    }

    @RequestMapping(value = "/test/1", method = RequestMethod.GET, name="测试get")
    public String test01Interceptor(@RequestBody TestQuery query){
        log.info("get - test/1-1111=====11111,flag:{}", query.getFlag());
        log.info("get - test/1-1111=====11111,id:{}", query.getId());
        log.info("get - test/1-1111=====11111,key:{}", query.getKey());
        log.info("get - test/1-1111=====11111,value:{}", query.getValue());
        return "success";
    }
    @RequestMapping(value = "/test/1", method = RequestMethod.POST, name="测试post")
    public String test03Interceptor(@RequestBody TestQuery testQuery){
        log.info("post - test/1-1111=====11111");
        return "post-1:"+testQuery.getId()+":"+testQuery.getKey()+":"+testQuery.getValue()+":"+testQuery.getFlag();
    }

    @RequestMapping(value = "/test/3", method = RequestMethod.POST, name="测试2")
    public String test02Interceptor(){
        log.info("post - test/3-1111=====11111");
        return "get-2";
    }
    @RequestMapping(value = "/test/2", method = RequestMethod.GET, name="测试2")
    @ReadOperation(produces = TextFormat.CONTENT_TYPE_004)
    public String test04Interceptor(HttpServletRequest request){
        return "post-2";
    }



    @RequestMapping(value = "/test", method = RequestMethod.GET, name="测试2")
    public String test05Interceptor(@RequestParam(name = "count") Integer count){
        if(count % 5 == 0){
            LOGGER.error("error");
        }
        if(count % 5 > 2){
            LOGGER.info("info");
        }
        try {
            if(count % 10 == 0){
                LOGGER.warn("warn");
            }
        } catch (Exception e) {
            log.error("cdfdgh:{}", "12", e);
            e.printStackTrace();
        }
        return "test-"+count;
    }


    @RequestMapping(value = "/test/6", method = RequestMethod.GET, name="测试2")
    public String test06(@RequestParam(name = "id") Integer id, @RequestParam(name = "key") String key,@RequestParam(name = "value") Boolean value){
        log.info("test06-[{}],[{}],[{}]",id, key, value);
        return "test-"+id;
    }

    @RequestMapping(value = "/well", method = RequestMethod.GET, name="测试-well")
    public String test06() {//192.168.1.101:
        return "1";
    }


    private int resultDiv(Integer count){
        return 5 / count;
    }

}
