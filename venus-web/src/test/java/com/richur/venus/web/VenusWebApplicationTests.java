package com.richur.venus.web;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.service.ExportExcelService;
import com.richur.venus.web.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VenusWebApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ExportExcelService exportExcelService;
    @Autowired
    private WebConfig webConfig;

    @Test
    public void contextLoads() {
        boolean exist = applicationContext.containsBean("exportExcelServiceImpl");

        System.out.println(exist);
//        System.out.println(exportExcelService.exportExcel());
    }

    @Test
    public void webConfigTest() {

        System.out.println(JSON.toJSONString(webConfig.getUserName()));
        System.out.println(JSON.toJSONString(webConfig.getRich()));
    }

    @Test
    public void test01() {
        Date date = new Date();
        System.out.println(String.valueOf(date.getTime()));
        System.out.println(String.valueOf(date));

    }


}
