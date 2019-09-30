package com.richur.venus.web.interceptor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author richur
 * @Date 2019/9/29 4:23 PM
 */
@Component
public class PrometheusMetricHttpInterceptor implements HandlerInterceptor {
    private static final String REQ_PARAM_TIMING = "start_time";
    private static final int UNDEFINED_HTTP_STATUS = 999;

    private static final Logger LOGGER = LoggerFactory.getLogger(PrometheusMetricHttpInterceptor.class);

    private static final Counter COUNTER = Counter.builder("Http请求统计")
            .tag("HttpCount", "HttpCount")
            .description("Http请求统计")
            .register(Metrics.globalRegistry);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //此处按url统计
//        request.setAttribute(REQ_PARAM_TIMING, System.currentTimeMillis());
        COUNTER.increment();
        LOGGER.info("http count:[{}]",COUNTER.count());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
