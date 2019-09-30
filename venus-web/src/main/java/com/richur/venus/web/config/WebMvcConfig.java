package com.richur.venus.web.config;

import com.alibaba.fastjson.JSON;
import com.richur.venus.web.helper.HttpServletRequestWrapperFilter;
import com.richur.venus.web.interceptor.PrometheusMetricHttpInterceptor;
import com.richur.venus.web.interceptor.TestInterceptor;
import com.richur.venus.web.interceptor.URLInterceptor;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @Author richur
 * @Date 2019/9/20 2:12 PM
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);

    @Autowired
    private URLInterceptor urlInterceptor;
    @Autowired
    private TestInterceptor testInterceptor;
    @Autowired
    private PrometheusMetricHttpInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        super.addInterceptors(registry);
//        registry.addInterceptor(urlInterceptor);
//        registry.addInterceptor(testInterceptor);
        registry.addInterceptor(interceptor);
        LOGGER.info("add interceptor {}", JSON.toJSONString(registry));

    }
    @Bean
    public FilterRegistrationBean httpServletRequestReplacedRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestWrapperFilter());
        return registration;
    }

}
