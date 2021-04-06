package com.richur.venus.design.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richur
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new StrategyA());
        strategies.put("B", new StrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
