package com.richur.venus.biz.util.string;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author richur
 */
@Slf4j
public class StringDemo {

    public static void main(String[] args) {
        String sql ="load data local inpath '/application/123.csv' INTO TABLE tmp_bdp.richur_test";

        String reg = "([' '|\t|\n|(|)])`?tmp_bdp`?.`?richur_test`?()";
        String s = sql.replaceAll(reg, "$1ods.88888ddd$2");
        log.info("after replace sql:{}", s);

    }
}
