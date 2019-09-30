package com.richur.venus.biz.model.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/**
 * @Author richur
 * @Date 2019/9/11 10:08 AM
 */
@Getter
@Setter
public class Article {
    private Long id;
    private String title;
    private LocalTime createTime;
    private String content;
    private String author;
}
