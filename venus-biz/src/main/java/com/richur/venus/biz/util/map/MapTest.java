package com.richur.venus.biz.util.map;

import com.google.common.annotations.VisibleForTesting;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author richur
 */
@Setter
@Getter
@Slf4j
public class MapTest {
    private Map<String, Object> map;
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("ajob1",14);
        map.put("1张",12);
        map.put("2网",13);
        map.put("4job2",15);

        System.out.println(map);


        int b = 1 | 3;
        System.out.println(b);


    }
}
