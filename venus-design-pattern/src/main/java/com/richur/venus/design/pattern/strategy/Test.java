package com.richur.venus.design.pattern.strategy;

/**
 * @author richur
 */
public class Test {
    public static void main(String[] args) {
        Strategy strategyA = StrategyFactory.getStrategy("A");
        strategyA.justDoIt();
        Strategy strategyB = StrategyFactory.getStrategy("B");
        strategyB.justDoIt();
    }
}
