package com.richur.venus.biz.util;

import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author richur
 * @Date 2019/9/11 5:36 PM
 */
public class ListUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListUtil.class);

    public static List<Integer> getRandomItems(List<Integer> leftBuckets, int num) {
        Random rand = new Random();
        List<Integer> availableBuckets = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            int randValue = rand.nextInt(leftBuckets.size());
            availableBuckets.add(leftBuckets.get(randValue));
            //buckets.remove(leftBuckets.get(randValue));
            leftBuckets.remove(randValue);
        }
        return availableBuckets;
    }

    public static void main(String[] args) {
//        List<Integer> leftBuckets = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            leftBuckets.add(i);
//        }
//
//        List<Integer> randomItems = getRandomItems(leftBuckets, 5);
//        System.out.println(leftBuckets);
//        System.out.println(randomItems);
//
//
//        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{
//            System.out.println("123");
//            LOGGER.info("www");
//        },1,10, TimeUnit.SECONDS);

//        List<Long> leftBuckets = new ArrayList<>();
//        leftBuckets.add(1L);
//        leftBuckets.add(2L);
//        System.out.println(leftBuckets.contains(1));

//        String tmp = new Strinnullg("null");
//        Long tmp = null;
//        System.out.println(0L >= tmp);
//        String resourceHdfsPath = "hdfs://uat-hadoop/department";
//
//
//        resourceHdfsPath = resourceHdfsPath.replace("hdfs://uat-hadoop", "viewfs://jssz-bigdata-test-cluster");
//        System.out.println(resourceHdfsPath);
//
//        List<String> list = new ArrayList<>();
//        list.add("abc");
//        list.add("cba");
//
//        System.out.println(list);

        List<String> targetMid = new ArrayList<String>();
        targetMid.add("1");
        targetMid.add("");
        targetMid.add("a 1");
        targetMid.add("21 ");
        System.out.println(targetMid);
        if(CollectionUtils.isNotEmpty(targetMid)){
            List<String> midList = new ArrayList<>(targetMid.size());
            for (String mid : targetMid) {
                if(!StringUtils.isBlank(mid)){
                    try{
                        Long.parseLong(mid.trim());
                    }catch (NumberFormatException e){
//                        logger.error("mid 配置照片那个含有非法字符:{}", mid);
                        System.out.println("mid 配置含有非法字符:"+mid);
//                        return JsonVO.failed("mid 配置照片那个含有非法字符:"+mid);
                    }
                    midList.add(mid.trim());
                } else {
                    System.out.println("空");
                }
            }
            targetMid = midList;
        }
        System.out.println(targetMid);

        List<String> targetBuvid = new ArrayList<String>();
        targetBuvid.add("asd ");
        targetBuvid.add("asd s");
        targetBuvid.add("");
        targetBuvid.add("aasd");
        System.out.println(targetBuvid);
        if(CollectionUtils.isNotEmpty(targetBuvid)){
            List<String> buvidList = new ArrayList<>(targetBuvid.size());
            for (String buvid : targetBuvid) {
                if(!StringUtils.isBlank(buvid)){
                    buvidList.add(buvid.trim());
                }
            }
            targetBuvid = buvidList;
        }
        System.out.println(targetBuvid);
    }
}
