package com.richur.venus.biz.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author richur
 * @Date 2019/8/27 12:24 PM
 */
@Setter
@Getter
public class User extends BaseRowModel {
    @ExcelProperty(value = "ID", index = 0)
    private Long id;
    @ExcelProperty(value = "姓名姓名", index = 1)
    private String name;
    @ExcelProperty(value = "人均播放时长", index = 2)
    private Integer gender;

    public User(){}
    public User(Long id, String name,Integer gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
