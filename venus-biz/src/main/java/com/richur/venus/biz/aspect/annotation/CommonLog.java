package com.richur.venus.biz.aspect.annotation;

public @interface CommonLog {

    /**
     * 详细信息
     * @return
     */
    String detail() default "";

    /**
     * 日志code
     * @return
     */
    int code() default 0;

    /**
     * 日志等级
     * @return
     */
    int level() default 0;
}
