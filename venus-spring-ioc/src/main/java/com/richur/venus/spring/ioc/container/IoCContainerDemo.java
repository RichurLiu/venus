package com.richur.venus.spring.ioc.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author richur
 */
public class IoCContainerDemo {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载资源
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        int count = reader.loadBeanDefinitions(location);
    }
}
