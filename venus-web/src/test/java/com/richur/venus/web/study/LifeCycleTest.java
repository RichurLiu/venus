package com.richur.venus.web.study;

import com.richur.venus.web.study.config.ConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author richur
 * @since v0.0.1
 */
public class LifeCycleTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigOfLifeCycle.class);
//        context.getB
        context.close();
    }
}
