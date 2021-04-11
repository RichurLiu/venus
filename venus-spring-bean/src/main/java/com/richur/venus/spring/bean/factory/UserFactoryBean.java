package com.richur.venus.spring.bean.factory;

import com.richur.venus.spring.ioc.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * lesson 36 14:17
 * {@link com.richur.venus.spring.ioc.User} Bean 的{@link FactoryBean}实现
 * @author richur
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
