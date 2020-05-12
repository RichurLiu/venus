package com.richur.venus.biz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author Richur
 * @Date 2019/12/2 6:07 下午
 */
@Setter
@Getter
@AllArgsConstructor
public class HttpClientResult implements Serializable {
    private static final long serialVersionUID = -3227095560958066744L;
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int code){
        this.code = code;
    }

}
