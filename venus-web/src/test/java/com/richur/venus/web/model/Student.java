package com.richur.venus.web.model;

import com.alibaba.fastjson.JSON;

/**
 * @Author richur
 * @Date 2019/9/27 8:29 PM
 */
public class Student extends Person {
    public int id;

    public int getId(){
        id = this.id;
        return super.id;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.id = 23;

        System.out.println(student.id);
        System.out.println(student.getId());
    }
}
