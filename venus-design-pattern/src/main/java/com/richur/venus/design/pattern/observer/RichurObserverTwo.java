package com.richur.venus.design.pattern.observer;

/**
 * @author richur
 */
public class RichurObserverTwo implements Observer{
    @Override
    public void update(String message) {
        System.out.println("RichurObserverTwo:" + message);
    }
}
