package com.richur.venus.web;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author richur
 * @Date 2019/9/18 10:01 AM
 */
public class MainTest {
    private static Cache<String, RateLimiter> urlLimiter = CacheBuilder.newBuilder().build();


    public static void main(String[] args) {
        Date date = new Date();
//        System.out.println(String.valueOf(date.getTime()));
//        System.out.println(String.valueOf(date));

//        for (int i = 0; i < 60; i++) {
//            testLimiter("test", i);
//        }
        test02();

    }


    private static String testLimiter(String key, int i) {
        try {
            RateLimiter limiter = urlLimiter.get(key, () -> RateLimiter.create(10));

            Thread.sleep(50);
            if (limiter.tryAcquire()) {
                System.out.println("success:" + i);
            } else {
                System.out.println("fail:" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }


    private static void test02() {
        String str = "active_duration:1.8264346289015858E9,play_duration:1.8281930892726852E10,share:1.6531573304525429,vv:826.6809068688183";
        String[] split = str.split(",");
        Map<String, Float> map = new HashMap<>();
        for (String s : split) {
            String[] split1 = s.split(":");

            map.put(split1[0], Float.parseFloat(split1[1]));

        }
        DecimalFormat df = new DecimalFormat("0.##");
        map.forEach((k, v) -> {
            System.out.println(k + ":" + df.format(v));
        });
    }


    private static void test03(){

        System.out.println("1");

        System.out.println("2");


    }
    private static void test04() {
        System.out.println("test04");
        try{

        }catch (Exception e){
            System.out.println("error");
        }
    }



    private static void test05(){
        try {
            File file = new File("/Users/richur/Desktop/wait.log");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            int lineCount = 1;
            while(null != (strLine = bufferedReader.readLine())){
//                logger.info("第[" + lineCount + "]行数据:[" + strLine + "]");
                lineCount++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
