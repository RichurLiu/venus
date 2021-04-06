package com.richur.venus.spring.ioc.repository;

import com.richur.venus.spring.ioc.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.naming.factory.BeanFactory;

import java.util.Collection;

/**
 * @author richur
 */
@Setter
@Getter
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

}
