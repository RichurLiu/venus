package com.richur.venus.biz.util.code.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author richur
 * @since v0.0.1
 */
@Setter
@Getter
public class Point {
    private String x;
    private Long y;

    public Point(String x, Long y) {
        this.x = x;
        this.y = y;
    }
}
