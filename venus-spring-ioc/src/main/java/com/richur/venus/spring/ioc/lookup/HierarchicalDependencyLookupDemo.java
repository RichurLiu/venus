package com.richur.venus.spring.ioc.lookup;

import com.richur.venus.spring.ioc.User;
import com.richur.venus.spring.ioc.annotation.Super;
import com.richur.venus.spring.ioc.container.AnnotationApplicationContextAsIoCContainerDemo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author richur
 */
public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 1. 获取 HierarchicalBeanFactory 《- ConfigurableBeanFactory <-ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        // 2. 设置Parent BeanFactory

        // 启动应用上线文
        applicationContext.refresh();
        // 关闭应用上下文
        applicationContext.close();
    }


}
