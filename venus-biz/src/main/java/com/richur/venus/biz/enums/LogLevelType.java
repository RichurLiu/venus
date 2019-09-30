package com.richur.venus.biz.enums;

import lombok.Getter;

@Getter
public enum LogLevelType {

    INFO("info", 2),
    WARN("warn", 3),
    ERROR("error", 4);

    private String key;
    private Integer value;

    LogLevelType(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
