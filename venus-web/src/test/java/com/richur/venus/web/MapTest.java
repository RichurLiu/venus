package com.richur.venus.web;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    @Test
    public void test01(){
        String requestParams = "{\"python_param\":\"<%=log_date%>\"}";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.putAll(JSON.parseObject(requestParams));
        System.out.println(requestParam);
        List<Integer> jobDockerInfoList = null;
        if(null != jobDockerInfoList) {
            for (Integer integer : jobDockerInfoList) {
                System.out.println(integer);
            }
        }
    }
}
