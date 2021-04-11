package com.richur.venus.spring.bean;

import com.richur.venus.spring.ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @author richur
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        User richUser = (User) beanFactory.getBean("rich-user");
        User user = beanFactory.getBean("user", User.class);
        System.out.println(richUser == user);

//        StringUtils.hasText()

    }
}
