package com.richur.venus.biz.util.code;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.model.po.User;
import com.richur.venus.biz.util.code.model.Point;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author richur
 * @Date 2019/9/4 2:21 PM
 */
public class ListDemo {
    public static void main(String[] args) {
//        ListDemo demo = new ListDemo();
//        demo.printHourMetrics();
        String dir = "/Users/richur/archer/t.sql";
        File file = new File(dir);
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
                System.out.println(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void changeA(Point a){
        Point b = new Point("2", 3L);
//        a.setY(b.getY());
//        a.setX(b.getX());
        a = b;
        System.out.println("sss:"+a);
    }




    private void printHourMetrics(){
//        Point p0 = new Point("2019102822", 2245L);
//        Point p1 = new Point("2019102823", 2389L);
        Point p2 = new Point("2019102900", 111L);
        Point p3 = new Point("2019102901", 234L);
        Point p4 = new Point("2019102902", 545L);
        Point p5 = new Point("2019102903", 956L);
        List<Point> points = new ArrayList<>(6);
//        points.add(p0);
//        points.add(p1);
        points.add(p5);
        points.add(p4);
        points.add(p3);
        points.add(p2);
        System.out.println(JSON.toJSONString(points));
        Collections.reverse(points);
        System.out.println(JSON.toJSONString(points));

        long preValue = 0;
        int count = 0;
        for(Point p : points){
            String dateHour = p.getX();
            if(count == 0){
                preValue = p.getY();
            } else {
                if(dateHour.endsWith("00")){
                    System.out.println(dateHour +":"+p.getY());
                } else {
                    System.out.println(dateHour +":"+ (p.getY() - preValue));
                }
                preValue = p.getY();
            }
            count ++ ;
        }
    }

    private void test01(){
        List<User> userList = new ArrayList<>();
        User user01 = new User();
        User user02 = new User();
        user01.setId(1L);
        user02.setId(2L);
        userList.add(user01);
        userList.add(user02);

        for (User user : userList) {
            System.out.println(JSON.toJSON(user));
        }
        for (User user : userList) {
            System.out.println(JSON.toJSON(user));
        }


        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,4,5,6));
        List<Integer> collect = intList.stream().map(item -> item * 10).collect(Collectors.toList());

        System.out.println(JSON.toJSON(collect));

        Map<Integer, Map<Long, List<User>>> intMap = new HashMap<>();
//        Map<Long, List<User>> map = new HashMap<>();
        Long groupId = 123L;
        Map<Long, List<User>> map = intMap.get(1);

        map.put(groupId, userList);
        System.out.println(JSON.toJSONString(map));
    }
}
