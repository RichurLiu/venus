package com.richur.venus.spring.bean;

import com.richur.venus.spring.ioc.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * @author richur
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        // 1.通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 属性设置
        beanDefinitionBuilder.addPropertyValue("age", 100);
        beanDefinitionBuilder.addPropertyValue("name", "riiiiiiicher");
        // 获取 BeanDefinition 实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 2. 通过AbstractBeanDefinition以及派生类

    }
}
