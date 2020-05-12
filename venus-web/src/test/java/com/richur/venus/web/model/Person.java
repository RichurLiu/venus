package com.richur.venus.web.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author richur
 * @Date 2019/9/27 8:29 PM
 */
@Slf4j
@Getter
@Setter
public class Person {
    private int id = 20;
    private int mid = 20;

    public String toString(){
        return JSON.toJSONString(this);
    }
}
