package com.richur.venus.biz.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author richur
 * @Date 2019/9/17 3:22 PM
 */
@Getter
@Setter
public class CommonLogBO {
    private String id;
    private LocalDateTime createTime;
    private String methodName;
    private String args;
    private String returnValue;
    private Integer level;
}
