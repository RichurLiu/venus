package com.richur.venus.spring.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author richur
 */
@Setter
@Getter
@ToString
public class User {
    private String name;
    private Integer age;

    public static User createUser(){
        User user = new User();
        user.setAge(25);
        user.setName("rich");
        return user;
    }
}
