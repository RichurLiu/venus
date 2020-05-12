package com.richur.venus.web.study.config;

import com.richur.venus.web.study.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author richur
 * @since v0.0.1
 * 1)指定初始化和销毁方法
 *     通过@Bean指定init-method和destroy-method
 * 2)通过Bean实现InitializingBean（定义初始化逻辑）
 *              DisposableBean(定义销毁逻辑)
 *3)(JSR250)通过@PostConstruct :在bean创建完成且属性赋值完成，来执行初始化方法
 *     @PreDestory 在容器销毁bean之前通知调用
 *4)BeanPostProcessor（interface）:bean 的后置处理器
 *   在bean初始化前后进行一些处理
 *   postProcessBeforeInitialization
 *   postProcessAfterInitialization
 *
 */
@ComponentScan("com.richur.venus.web.study.bean")
@Configuration
public class ConfigOfLifeCycle {

//    @Bean(initMethod = "init",destroyMethod = "destroy")
//    public Car car(){
//        return  new Car();
//    }
}
