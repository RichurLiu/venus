package com.richur.venus.web.controller.experiment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author richur
 * @since v0.0.1
 */
public class MatchParams {

    private Map<String, String> params   = new ConcurrentHashMap<>();

    public static final String  BUVID    = "buvid";
    public static final String  MID      = "mid";
    public static final String  PLATFORM = "platform";

    public Long getLong(String key) {
        String value = params.get(key);
        if (value == null) {
            return null;
        }
        return Long.valueOf(value);
    }

    public String getString(String key) {
        String value = params.get(key);
        return value;
    }

    public Map<String, String> getAll() {
        return params;
    }

    public void put(String key, String value) {
        params.put(key, value);
    }

    public void put(Map<String, String> batch) {
        params.putAll(batch);
    }
}
