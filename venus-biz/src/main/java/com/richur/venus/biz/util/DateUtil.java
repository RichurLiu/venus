package com.richur.venus.biz.util;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author richur
 * @Date 2019/9/2 1:45 PM
 */
public class DateUtil {

    public static void main(String[] args) {
//        Long time = new DateTime().dayOfYear().roundFloorCopy().toDateTime().getMillis();
//        System.out.println(time);
//        System.out.println(new DateTime().dayOfYear().roundFloorCopy().getMillis());
//        System.out.println(new DateTime().dayOfYear().roundFloorCopy().plusDays(1).getMillis());
//
//        long day = new DateTime().dayOfYear().roundFloorCopy().getMillis();
//        long dayPost = new DateTime().dayOfYear().roundFloorCopy().plusDays(1).getMillis();
//
//        System.out.println(dayPost - day);
//        System.out.println(24*60*60*100);

        long latestDate = new DateTime().minuteOfDay().roundFloorCopy().getMillis();

//        System.out.println(latestDate);
//        System.out.println(new DateTime().minuteOfDay().roundFloorCopy().minusMinutes(1));
//        System.out.println(new DateTime().minuteOfDay().roundFloorCopy().minusMinutes(0));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("yyyyMMddHHmm");

//
//
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("11232");
//            }
//        },1000,1000);

        String maxLogDate = "202001171324";
        try {
            Date date = minuteFormat.parse(maxLogDate);
            maxLogDate = minuteFormat.format(new DateTime(date).minuteOfDay().roundFloorCopy().minusMinutes(1).getMillis());
        } catch (ParseException e) {
            //LOGGER.error("日期转换失败,maxLogDate:{}", maxLogDate, e);
        }

        System.out.println(maxLogDate);


    }

    private static int fun(int a, int b){
        System.out.println("int");
        try {
            return a / b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int fun(Integer a, Integer b){
        System.out.println("Integer");
        return a + b;
    }




}
