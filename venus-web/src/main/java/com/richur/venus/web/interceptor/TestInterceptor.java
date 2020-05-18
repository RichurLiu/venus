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

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author richur
 * @Date 2019/9/20 10:42 AM
 */
@Component
public class TestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestInterceptor.class);


    private Cache<String, RateLimiter> urlLimiter = CacheBuilder.newBuilder().build();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //LOGGER.info("preHandle" + JSON.toJSONString(request));
//        LOGGER.info(request.getRequestURI());
//        LOGGER.info(request.getRequestURL().toString());

        LOGGER.info("TestInterceptor==============");
        RateLimiter limiter = urlLimiter.get("venus", ()-> RateLimiter.create(100));
        boolean contains = request.getRequestURI().contains("/venus/test/1");
        boolean b = limiter.tryAcquire();
        if(b){
            LOGGER.info("true");
        } else {
            LOGGER.info("false, 触发限流");
        }

        if(contains){
            if(request.getMethod().toLowerCase().equals("post")){
                String body = getBody(request);
//                System.out.println(body);
                LOGGER.info("true------------"+ body);
//                LOGGER.info("true------------");
            }
            String count = request.getParameter("count");

            LOGGER.info("getParameter------------:{}", getBody(request));
            LOGGER.info("getParameter------------:{}", count);
            return  true;
        } else {
//            LOGGER.error("false------------");
            String count = request.getParameter("count");
            LOGGER.info("getParameter------------:{}", count);

            return true;
        }


//        if(contains){
//            LOGGER.info(request.getMethod());
//            request.getRequestDispatcher("/venus/test/2").forward(request, response);
//        }
//        LOGGER.info("TestInterceptor==============");
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        LOGGER.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        LOGGER.info("afterCompletion");
    }



    private String getBody(HttpServletRequest request) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
