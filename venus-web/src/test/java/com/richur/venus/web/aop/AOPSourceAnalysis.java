package com.richur.venus.web.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author richur
 * @since v0.0.1
 *
 * AOP 原理
 *1.@EnableAspectJAutoProxy是什么？
 *  @Import(AspectJAutoProxyRegistrar.class)：给容器中导入AspectJAutoProxyRegistrar
 *      利用AspectJAutoProxyRegistrar自定义给容器注册bean，
 *  给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *
 *2.AnnotationAwareAspectJAutoProxyCreator
 *    AnnotationAwareAspectJAutoProxyCreator
 *      ->AspectJAwareAdvisorAutoProxyCreator
 *          ->AbstractAdvisorAutoProxyCreator
 *              ->AbstractAutoProxyCreator
 *                implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                关注后置处理器（在bean初始化完成后做的事情），自动装配BeanFactory
 *
 * AbstractAutoProxyCreator.setBeanFactory()
 * AbstractAutoProxyCreator有后置处理器逻辑
 *
 * AbstractAdvisorAutoProxyCreator.setBeanFactory()->initBeanFactory()
 *
 * AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 * 流程
 *  1）传入配置类，创建IOC容器
 *  2）注册配置类，调用refresh()方法
 *  3）
 */
@EnableAspectJAutoProxy
public class AOPSourceAnalysis {


}
