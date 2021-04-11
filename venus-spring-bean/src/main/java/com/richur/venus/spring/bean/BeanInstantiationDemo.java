package com.richur.venus.spring.bean;

import com.richur.venus.spring.ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author richur
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstance= beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean= beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userByInstance);
        System.out.println(userByFactoryBean);

        System.out.println(user == userByInstance);
        System.out.println(user == userByFactoryBean);


    }
}
