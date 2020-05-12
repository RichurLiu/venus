package com.richur.venus.web;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;
import com.richur.venus.web.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author richur
 * @Date 2019/9/18 10:01 AM
 */
@Slf4j
public class MainTest {
    private static Cache<String, RateLimiter> urlLimiter = CacheBuilder.newBuilder().build();


    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(142,0);
        map.put(1,142);
        map.put(3,1);

        int departmentId = 3;
        //获取一级目录

        int deep = 4;
        boolean flag = false;

        Integer departmentDTO = map.get(departmentId);
        int parentDepartmentId = departmentDTO;
        while(parentDepartmentId != 0 && deep > 0){
            departmentDTO = map.get(parentDepartmentId);
            if(null == departmentDTO){
                flag = true;
                log.warn("departmentDTO is null, current departmentId:[{}}", departmentId);
                break;
            }
            departmentId = parentDepartmentId;
            parentDepartmentId = departmentDTO;
            deep--;
        }
        //topic id 规定格式
        String topic = "ArcherConstant.TOPIC_PREFIX "+ departmentId;
        if(parentDepartmentId !=0){
            topic = "ArcherConstant.COMMON_TOPIC";
            log.warn("department id:[{}] is not top department, use common topic:[{}]", departmentId, topic);
        }
        if(flag){
            topic = "ArcherConstant.COMMON_TOPIC";
        }

        System.out.println(topic);
        System.out.println(deep);



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


    private static void test03() {

        System.out.println("1");

        System.out.println("2");


    }

    private static void test04() {
        System.out.println("test04");
        try {

        } catch (Exception e) {
            System.out.println("error");
        }
    }


    private static void test05() {
        try {
            File file = new File("/Users/richur/Desktop/wait.log");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            int lineCount = 1;
            while (null != (strLine = bufferedReader.readLine())) {
//                logger.info("第[" + lineCount + "]行数据:[" + strLine + "]");
                lineCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void test06() {
        String addrStr = "grpc://172.22.33.121:8081";
        String[] split = addrStr.split("://")[1].split(":");
        Arrays.stream(split).forEach(e -> System.out.println(e));

    }

    private static void test07(){
        for (int i = 0; i < 3000; i++) {
            log.info("test info log, ghjkllkjhghjkl;lkjhgghjkl;lkjhgfghjkl");
        }
    }

    @Test
    public void test08(){
        Person person = new Person();
        person.setId(12);
        person.setMid(123);
        System.out.println(person.toString());
    }

    @Test
    public void test09(){
        String name = "/Users/richur/Downloads/part-00000";
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] split = str.split(",");
                if(split.length != 11){
                    System.out.println("---"+str);
                } else {
                    System.out.println("-");
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test10(){
        String name = "/Users/richur/Downloads/jstack0430-grpc-thread.log";
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            int count=0;
            Map<String, Integer> mapCount = new HashMap<>(1400);
            while ((str = bf.readLine()) != null && count < 10) {
                String[] split = str.split(" ");
                String grpc = split[0];

                grpc = grpc.replace("\"","").split("-")[4];

                if(null != mapCount.get(grpc)){
                    System.out.println(grpc);
                } else {
                    mapCount.put(grpc, 1);
                }

//                System.out.println(grpc);

//                if(split.length != 11){
//                    System.out.println("---"+str);
//                } else {
//                    System.out.println("-");
//                }
//                count ++;
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test11(){
            String url ="jdbc:clickhouse://10.69.189.15:8123/test";

            String[] split = url.split("jdbc:clickhouse://")[1].split(":");

            System.out.println(split[0]);
            System.out.println(split[1]);

    }



}
