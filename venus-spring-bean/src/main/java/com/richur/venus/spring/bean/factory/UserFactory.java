package com.richur.venus.spring.bean.factory;

import com.richur.venus.spring.ioc.User;

/**
 * @author richur
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
