package com.richur.venus.web.study.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author richur
 * @since v0.0.1
 */
@Slf4j
@Component
public class CarImp implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        //配置文件设置完成之后调用，相当于初始化
        log.info("CarImp init...");
    }

    @Override
    public void destroy() throws Exception {
        log.info("CarImp destroy...");
    }
}
