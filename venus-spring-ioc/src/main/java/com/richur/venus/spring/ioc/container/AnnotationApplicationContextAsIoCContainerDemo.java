package com.richur.venus.spring.ioc.container;

import com.richur.venus.spring.ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author richur
 */
public class AnnotationApplicationContextAsIoCContainerDemo {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge(20);
        user.setName("zhang");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(users);
        }
    }
}
