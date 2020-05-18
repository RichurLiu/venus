package com.richur.venus.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author richur
 * @Date 2019/9/20 10:42 AM
 */
@Component
public class URLInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(URLInterceptor.class);


    private Cache<String, RateLimiter> urlLimiter = CacheBuilder.newBuilder().build();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //LOGGER.info("preHandle" + JSON.toJSONString(request));



//        RateLimiter limiter = urlLimiter.get("venus", ()-> RateLimiter.create(10));
//        boolean contains = request.getRequestURI().contains("/venus/test/1");
//        boolean b = limiter.tryAcquire();
//        if(b){
//            LOGGER.info("true-------------");
//            return  true;
//        } else {
//            LOGGER.error("false------------");
//            return false;
//        }


//        if(contains){
//            LOGGER.info(request.getMethod());
//            request.getRequestDispatcher("/venus/test/2").forward(request, response);
//        }
        String count = request.getParameter("count");
//        LOGGER.info("getParameter------------:{}", JSON.toJSON(request));
        LOGGER.info("URLInterceptor==============");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("afterCompletion");
    }
}
