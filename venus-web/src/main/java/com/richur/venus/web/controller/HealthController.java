package com.richur.venus.web.controller;

import com.richur.venus.web.query.TestQuery;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author richur
 * @Date 2019/9/20 2:07 PM
 */
@RestController
@RequestMapping("/venus")
public class HealthController {

    @RequestMapping("/health")
    public String healthCheck(){
        return "OK";
    }

    @RequestMapping(value = "/test/1", method = RequestMethod.GET, name="测试get")
    public String test01Interceptor(){
        return "get-1";
    }
    @RequestMapping(value = "/test/1", method = RequestMethod.POST, name="测试post")
    public String test03Interceptor(@RequestBody TestQuery testQuery){
        return "post-1";
    }

    @RequestMapping(value = "/test/2", method = RequestMethod.GET, name="测试2")
    public String test02Interceptor(){
        return "get-2";
    }
    @RequestMapping(value = "/test/2", method = RequestMethod.POST, name="测试2")
    public String test04Interceptor(HttpServletRequest request){
        return "post-2";
    }



    @RequestMapping(value = "/tetttst1/param/hsfs", method = RequestMethod.GET, name="测试2")
    public String test05Interceptor(@RequestParam(name = "path", required = true) String path){

        return "post-2"+path;
    }

}
