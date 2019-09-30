package com.richur.venus.biz.aspect;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.aspect.annotation.CommonLog;
import com.richur.venus.biz.model.CommonLogBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


/**
 * @Author richur
 * @Date 2019/9/3 12:04 AM
 */

@Component
@Aspect
public class CommonLogAspect {

    @Pointcut("@annotation(com.richur.venus.biz.aspect.annotation.CommonLog))")
    public void commonLog() {
    }

    @Around("commonLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                addLog(joinPoint, res, time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addLog(JoinPoint joinPoint, Object res, long time) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        CommonLogBO commonLogBO = new CommonLogBO();
        commonLogBO.setCreateTime(LocalDateTime.now());
        commonLogBO.setId(UUID.randomUUID().toString());
        commonLogBO.setReturnValue(JSON.toJSONString(res));
        commonLogBO.setArgs(JSON.toJSONString(joinPoint.getArgs()));
        commonLogBO.setMethodName(signature.getDeclaringTypeName() + "." + signature.getName());
        CommonLog annotation = signature.getMethod().getAnnotation(CommonLog.class);
        if(annotation != null){
            commonLogBO.setLevel(annotation.level());
        }
        //这里记录日志
        System.out.println("记录日志:" + JSON.toJSONString(commonLogBO));
    }
}
