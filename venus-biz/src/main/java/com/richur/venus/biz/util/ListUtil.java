package com.richur.venus.biz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        List<Integer> leftBuckets = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            leftBuckets.add(i);
        }

        List<Integer> randomItems = getRandomItems(leftBuckets, 5);
        System.out.println(leftBuckets);
        System.out.println(randomItems);


        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{
            System.out.println("123");
            LOGGER.info("www");
        },1,10, TimeUnit.SECONDS);
    }
}
