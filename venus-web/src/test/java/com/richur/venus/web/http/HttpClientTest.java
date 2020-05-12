package com.richur.venus.web.http;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.model.HttpClientResult;
import com.richur.venus.biz.util.HttpClientUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Richur
 * @Date 2019/12/2 6:18 下午
 */
@Slf4j
public class HttpClientTest {


    public static void main(String[] args) {
//        post();
//        get();
        mapToJson();
    }


    private static void get(){
        String url = "http://localhost:9003/venus/test/6?id=123";
        Map<String,String> params = new HashMap<>();
//        params.put(   "id", "123");
        params.put(  "key", "0124");
        params.put("value", "false");
        try {
            HttpClientResult httpClientResult = HttpClientUtils.doGet(url, params);
            log.info("{}",httpClientResult.getCode());
            log.info("{}",httpClientResult.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void post() {
        String url = "http://localhost:9003/venus/test/1";
        Map<String,String> params = new HashMap<>();
        params.put(   "id", "123");
        params.put(  "key", "0124");
        params.put("value", "124");
        params.put( "flag", "false");
        try {
            HttpClientResult httpClientResult = HttpClientUtils.doPost(url, params);
            log.info("{}",httpClientResult.getCode());
            log.info("{}",httpClientResult.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void mapToJson(){
        Map<String,String> params = new HashMap<>();
        params.put(   "id", "123");
        params.put(  "key", "0124");
        params.put("value", "124");
        params.put( "flag", "false");
        System.out.println(JSON.toJSONString(params));
    }
}
