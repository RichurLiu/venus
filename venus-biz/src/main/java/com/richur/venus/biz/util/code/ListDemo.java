package com.richur.venus.biz.util.code;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.model.po.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author richur
 * @Date 2019/9/4 2:21 PM
 */
public class ListDemo {
    public static void main(String[] args) {
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
