package com.richur.venus.biz.util.test;

import lombok.Getter;
import lombok.Setter;

/**
 * @author richur
 * @since b0.0.1
 */
@Setter
@Getter
public class AutoResultVO {
    private Long historyProjectId;
    private Integer offset;
    private String offsetTag;
    private Boolean hdfsSave;
    private Integer jobType;
    private String sql;
    private String log;
    private Integer status;
    private Integer code;
    private String msg;
}
