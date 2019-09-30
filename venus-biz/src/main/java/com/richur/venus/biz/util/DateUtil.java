package com.richur.venus.biz.util;

import org.joda.time.DateTime;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author richur
 * @Date 2019/9/2 1:45 PM
 */
public class DateUtil {
    public static void main(String[] args) {
        Long time = new DateTime().dayOfYear().roundFloorCopy().toDateTime().getMillis();
        System.out.println(time);
        System.out.println(new DateTime().dayOfYear().roundFloorCopy().toDateTime());
        System.out.println(new DateTime());



        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("11232");
            }
        },1000,1000);
    }




}
