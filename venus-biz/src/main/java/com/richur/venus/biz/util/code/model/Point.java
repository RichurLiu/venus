package com.richur.venus.biz.util.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author richur
 * @since v0.0.1
 */
@Setter
@Getter
@ToString
public class Point {
    private String x;
    private Long y;

    public Point(String x, Long y) {
        this.x = x;
        this.y = y;
    }
}
